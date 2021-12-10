package com.maksonic.numbers.core.redux

import com.maksonic.numbers.core.redux.marker.Action
import com.maksonic.numbers.core.redux.marker.Effect
import com.maksonic.numbers.core.redux.marker.State
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow

/**
 * @Author: maksonic on 10.12.2021
 */
interface Store<S : State, A : Action, E : Effect?> {
    val state: StateFlow<S>
    val sideEffect: Flow<E>

    suspend fun dispatch(action: A)
    suspend fun setSideEffect(effectBuilder: () -> E)

    open class BaseStore<S: State, A: Action, E: Effect?>(
        initialState: S,
        private val reducer: Reducer<S, A>,
        private val middlewares: List<Middleware<S, A, E>> = emptyList()
    ) : Store<S, A, E> {

        private val _state = MutableStateFlow(initialState)
        override val state: StateFlow<S>
            get() = _state

        private val currentState: S
            get() = _state.value

        private val _sideEffect: Channel<E> = Channel()
        override val sideEffect: Flow<E>
            get() = _sideEffect.receiveAsFlow()

        override suspend fun dispatch(action: A) {
            middlewares.forEach { middleware ->
                middleware.process(action, currentState, this)
            }

            val newState = reducer.reduce(currentState, action)
            _state.value = newState
        }

        override suspend fun setSideEffect(effectBuilder: () -> E) {
            coroutineScope { _sideEffect.send(effectBuilder.invoke()) }
        }
    }
}