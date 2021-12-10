package com.maksonic.numbers.presentation.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.maksonic.numbers.core.base.BaseScreen
import com.maksonic.numbers.core.utils.KeyboardBehavior
import com.maksonic.numbers.presentation.main_screen.databinding.ScreenMainBinding
import org.koin.android.ext.android.inject

/**
 * @Author: maksonic on 10.12.2021
 */
class MainScreen : BaseScreen<ScreenMainBinding>() {
    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> ScreenMainBinding
        get() = ScreenMainBinding::inflate

    private val keyboardBehavior: KeyboardBehavior by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onResume() {
        super.onResume()
        keyboardBehavior.showKeyboard(binding.inputNumber)
    }

    override fun onStop() {
        super.onStop()
        keyboardBehavior.hideKeyboard(binding.root)
    }

    override fun prepareView(savedInstanceState: Bundle?) {
        requireActivity().setTitle(R.string.scr_main_title)
        hideNavigationBackIcon()
    }
}