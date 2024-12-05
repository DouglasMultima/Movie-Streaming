package com.compose.moviestreaming.presenter.screens.authentication.signup.state

data class SignupState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
)
