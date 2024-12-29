package com.compose.moviestreaming.presenter.screens.authentication.signup.action

import com.compose.moviestreaming.core.enums.input.InputType

sealed class SignupAction {

    data class OnValueChange(
        val value: String,
        val type: InputType
    ) : SignupAction()

    data object OnPasswordVisibilityChange : SignupAction()

    data object OnSignup : SignupAction()

    data object ResetError : SignupAction()


}