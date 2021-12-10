package com.maksonic.numbers.presentation.main_screen.core

import android.content.Context
import android.util.Patterns
import com.maksonic.numbers.core.redux.Middleware
import com.maksonic.numbers.core.redux.Store
import com.maksonic.numbers.core.utils.InternetConnection
import com.maksonic.numbers.core.utils.Result
import com.maksonic.numbers.domain.FetchNumberFactUseCase
import com.maksonic.numbers.presentation.main_screen.R
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import java.util.regex.Pattern

/**
 * @Author: maksonic on 10.12.2021
 */
class MainMiddleware(
    private val fetchFactUseCase: FetchNumberFactUseCase,
    private val internetConnection: InternetConnection,
    private val context: Context
) : Middleware<MainViewState, MainAction, MainEffect> {
    override suspend fun process(
        action: MainAction,
        currentState: MainViewState,
        store: Store<MainViewState, MainAction, MainEffect>
    ) {
        when (action) {
            is MainAction.FetchNumberFact -> {
                if (!internetConnection.checkInternet(context)) {
                    store.dispatch(MainAction.InternetNotFound)
                } else {
                    fetchNumberFact(store, action)
                }
            }

            is MainAction.InternetNotFound -> {
                store.setSideEffect { MainEffect.ShowInternetDialog }
            }
        }
    }

    private suspend fun fetchNumberFact(
        store: Store<MainViewState, MainAction, MainEffect>,
        action: MainAction.FetchNumberFact
    ) {
        val inputNumber = action.number?.trim()
        val pattern = Pattern.compile("[0-9]+")

        if (inputNumber.isNullOrEmpty()) {
            store.setSideEffect {
                MainEffect.ShowNumberError(
                    context.resources.getString(R.string.error_empty_input)
                )
            }
        } else if (!pattern.matcher(inputNumber).matches()) {
            store.setSideEffect {
                MainEffect.ShowNumberError(
                    context.resources.getString(R.string.error_input_not_number)
                )
            }
        } else {
            fetchFactUseCase.invoke(inputNumber.toInt())
                .onStart { store.dispatch(MainAction.FetchingStarted) }
                .collect {
                    when (it) {
                        is Result.Success -> {
                            store.dispatch(MainAction.FetchingFinished(it.data.text))
                        }
                        is Result.Error -> {
                            store.dispatch(MainAction.FetchingError(it.exception.localizedMessage))
                        }
                    }
                }
        }
    }
}
