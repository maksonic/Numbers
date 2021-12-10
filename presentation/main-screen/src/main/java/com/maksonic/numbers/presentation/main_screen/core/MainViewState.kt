package com.maksonic.numbers.presentation.main_screen.core

import com.maksonic.numbers.core.redux.marker.State

/**
 * @Author: maksonic on 10.12.2021
 */
data class MainViewState(
    val number: Int = 0,
    val data: String = "",
    val showLoading: Boolean = false,
    val error: String? = null,
    val isDisconnected: Boolean = false
) : State