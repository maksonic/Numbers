package com.maksonic.numbers.presentation.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.maksonic.numbers.core.base.BaseScreen
import com.maksonic.numbers.core.utils.KeyboardBehavior
import com.maksonic.numbers.core.utils.ViewVisibility.visibleOrInvisible
import com.maksonic.numbers.core.utils.click
import com.maksonic.numbers.presentation.main_screen.core.MainEffect
import com.maksonic.numbers.presentation.main_screen.core.MainViewState
import com.maksonic.numbers.presentation.main_screen.databinding.ScreenMainBinding
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @Author: maksonic on 10.12.2021
 */
class MainScreen : BaseScreen<ScreenMainBinding>() {
    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> ScreenMainBinding
        get() = ScreenMainBinding::inflate

    private val viewModel by viewModel<MainViewModel>()
    private val keyboard: KeyboardBehavior by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun prepareView(savedInstanceState: Bundle?) {
        requireActivity().setTitle(R.string.scr_main_title)
        hideNavigationBackIcon()
        stateObserver.invoke()
        sideEffectObserver.invoke()
        confirmNumberClicked()
    }

    override fun onResume() {
        super.onResume()
        keyboard.showKeyboard(binding.inputNumber)
    }

    override fun onStop() {
        super.onStop()
        keyboard.hideKeyboard(binding.inputNumber)
    }

    private val stateObserver = {
        lifecycleScope.launch {
            viewModel.viewState
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect { observeViewState(it) }
        }
    }
    private val sideEffectObserver = {
        lifecycleScope.launch {
            viewModel.sideEffect
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect { observeSideEffect(it) }
        }
    }

    private fun observeViewState(viewState: MainViewState) {
        setNumberFactText(viewState)
        setLoadingIndicatorBehavior(viewState)
    }

    private fun observeSideEffect(effect: MainEffect) {
        when (effect) {
            is MainEffect.ShowInternetDialog -> {
                keyboard.hideKeyboard(binding.root)
                Toast.makeText(context, "Dialog", Toast.LENGTH_SHORT).show()
            }
            is MainEffect.ShowNumberError -> {
                Toast.makeText(context, effect.error, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setNumberFactText(viewState: MainViewState) {
        binding.txtBody.text = viewState.data
    }

    private fun setLoadingIndicatorBehavior(viewState: MainViewState) {
        binding.progress.visibleOrInvisible(viewState.showLoading, true)
    }

    private fun confirmNumberClicked() {
        binding.confirmNumber.click {
            val number = binding.inputNumber.text.toString()
            viewModel.result(number)
        }
    }
}
