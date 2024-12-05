package com.compose.moviestreaming.presenter.screens.authentication.signup.action

import com.compose.moviestreaming.core.enums.InputType

sealed class SignupAction {

    data class OnValueChange(
        val value: String,
        val type: InputType
    ) : SignupAction()

}