package com.maksonic.numbers.core.redux

import com.maksonic.numbers.core.redux.marker.Action
import com.maksonic.numbers.core.redux.marker.Effect
import com.maksonic.numbers.core.redux.marker.State

/**
 * @Author: maksonic on 10.12.2021
 */
interface Middleware<S : State, A : Action, E : Effect?> {
    suspend fun process(action: A, currentState: S, store: Store<S, A, E>)
}