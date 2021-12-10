package com.maksonic.numbers

import android.app.Application
import com.maksonic.numbers.core.coreModule
import com.maksonic.numbers.data.dataModule
import com.maksonic.numbers.domain.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @Author: maksonic on 10.12.2021
 */
class App : Application() {

    private val moduleList = listOf(coreModule, domainModule, dataModule)

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(moduleList)
        }
    }
}