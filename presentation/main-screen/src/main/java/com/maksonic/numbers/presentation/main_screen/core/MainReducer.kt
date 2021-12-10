package com.maksonic.numbers.presentation.main_screen.core

import com.maksonic.numbers.core.redux.Reducer

/**
 * @Author: maksonic on 10.12.2021
 */
class MainReducer : Reducer<MainViewState, MainAction> {
    override fun reduce(currentState: MainViewState, action: MainAction): MainViewState {
        return when (action) {
            is MainAction.FetchingStarted -> currentState.copy(showLoading = true)

            is MainAction.FetchingFinished -> currentState.copy(
                showLoading = false,
                data = action.data
            )

            is MainAction.FetchingError -> currentState.copy(
                showLoading = false,
                error = action.error
            )

            is MainAction.InternetNotFound -> currentState.copy(
                showLoading = false,
                data = "Ничего не найдено",
                isDisconnected = true
            )
            else -> currentState
        }
    }
}