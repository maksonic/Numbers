package com.maksonic.numbers.core.redux

import com.maksonic.numbers.core.redux.marker.Action
import com.maksonic.numbers.core.redux.marker.State

/**
 * @Author: maksonic on 10.12.2021
 */
interface Reducer<S : State, A : Action> {
    fun reduce(currentState: S, action: A): S
}