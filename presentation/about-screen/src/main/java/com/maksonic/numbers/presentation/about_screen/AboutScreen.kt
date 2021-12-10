package com.maksonic.numbers.presentation.about_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.maksonic.numbers.core.base.BaseScreen
import com.maksonic.numbers.presentation.about_screen.databinding.ScreenAboutBinding

/**
 * @Author: maksonic on 10.12.2021
 */
class AboutScreen : BaseScreen<ScreenAboutBinding>() {
    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> ScreenAboutBinding
        get() = ScreenAboutBinding::inflate

    override fun prepareView(savedInstanceState: Bundle?) {
    }
}