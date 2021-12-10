package com.maksonic.numbers.presentation.main_screen.di

import com.maksonic.numbers.presentation.main_screen.MainViewModel
import com.maksonic.numbers.presentation.main_screen.core.MainStore
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @Author: maksonic on 10.12.2021
 */
val mainScreenModule = module {
    viewModel {
        MainViewModel(
            store = MainStore(
                fetchFactUseCase = get(),
                internetConnection = get(),
                context = get()
            )
        )
    }
}