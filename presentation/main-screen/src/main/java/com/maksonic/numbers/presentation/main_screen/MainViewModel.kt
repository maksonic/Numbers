package com.maksonic.numbers.presentation.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maksonic.numbers.core.redux.Store
import com.maksonic.numbers.presentation.main_screen.core.MainAction
import com.maksonic.numbers.presentation.main_screen.core.MainEffect
import com.maksonic.numbers.presentation.main_screen.core.MainViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * @Author: maksonic on 10.12.2021
 */
class MainViewModel(val store: Store<MainViewState, MainAction, MainEffect>) : ViewModel() {

    val viewState: StateFlow<MainViewState> = store.state
    val sideEffect: Flow<MainEffect> = store.sideEffect

    fun result(value: String) {
        viewModelScope.launch {
            store.dispatch(MainAction.FetchNumberFact(value))
        }
    }
}