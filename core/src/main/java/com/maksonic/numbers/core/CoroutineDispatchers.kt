package com.maksonic.numbers.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * @Author: maksonic on 10.12.2021
 */
interface CoroutineDispatchers {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher

    class Base : CoroutineDispatchers {
        override val main: CoroutineDispatcher = Dispatchers.Main
        override val io: CoroutineDispatcher = Dispatchers.IO
    }
}
