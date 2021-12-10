package com.maksonic.numbers.presentation.main_screen.core

import com.maksonic.numbers.core.redux.marker.Action
import com.maksonic.numbers.core.redux.marker.Effect

/**
 * @Author: maksonic on 10.12.2021
 */
sealed class MainAction : Action {
    object FetchingStarted : MainAction()

    data class FetchNumberFact(val number: String?) : MainAction()
    data class FetchingFinished(val data: String) : MainAction()
    data class FetchingError(val error: String?) : MainAction()

    object InternetNotFound : MainAction()
}

sealed class MainEffect : Effect {
    object ShowInternetDialog : MainEffect()
    data class ShowNumberError(val error: String?) : MainEffect()
    object NavigateToAboutScreen : MainEffect()
}

