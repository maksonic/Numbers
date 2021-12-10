package com.maksonic.numbers.presentation.main_screen.core

import android.content.Context
import com.maksonic.numbers.core.redux.Store
import com.maksonic.numbers.core.utils.InternetConnection
import com.maksonic.numbers.domain.FetchNumberFactUseCase

/**
 * @Author: maksonic on 10.12.2021
 */
class MainStore(
    fetchFactUseCase: FetchNumberFactUseCase,
    internetConnection: InternetConnection,
    context: Context
) : Store.BaseStore<MainViewState, MainAction, MainEffect>(
    initialState = MainViewState(),
    reducer = MainReducer(),
    middlewares = listOf(MainMiddleware(fetchFactUseCase, internetConnection, context))
)