package com.maksonic.numbers

import android.app.Application
import androidx.emoji2.bundled.BundledEmojiCompatConfig
import androidx.emoji2.text.EmojiCompat
import com.maksonic.numbers.core.coreModule
import com.maksonic.numbers.data.dataModule
import com.maksonic.numbers.domain.domainModule
import com.maksonic.numbers.presentation.main_screen.di.mainScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @Author: maksonic on 10.12.2021
 */
class App : Application() {

    private val moduleList = listOf(coreModule, domainModule, dataModule, mainScreenModule)

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(moduleList)
        }
        initEmoji()
    }

    private fun initEmoji() {
        val config = BundledEmojiCompatConfig(this)
        EmojiCompat.init(config)
    }
}