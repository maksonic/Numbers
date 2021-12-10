package com.maksonic.numbers.core

import com.maksonic.numbers.core.utils.InternetConnection
import com.maksonic.numbers.core.utils.KeyboardBehavior
import org.koin.dsl.module

/**
 * @Author: maksonic on 10.12.2021
 */
val coreModule = module {
    single<CoroutineDispatchers> { CoroutineDispatchers.Base() }
    single<KeyboardBehavior> { KeyboardBehavior.Base() }
    factory<InternetConnection> { InternetConnection.Base() }
}