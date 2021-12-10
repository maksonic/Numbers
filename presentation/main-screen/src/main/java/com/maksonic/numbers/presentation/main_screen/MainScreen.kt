package com.maksonic.numbers.presentation.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.maksonic.numbers.core.base.BaseScreen
import com.maksonic.numbers.presentation.main_screen.databinding.ScreenMainBinding

/**
 * @Author: maksonic on 10.12.2021
 */
class MainScreen : BaseScreen<ScreenMainBinding>() {
    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> ScreenMainBinding
        get() = ScreenMainBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun prepareView(savedInstanceState: Bundle?) {
        requireActivity().setTitle(R.string.scr_main_title)
        hideNavigationBackIcon()
    }
}