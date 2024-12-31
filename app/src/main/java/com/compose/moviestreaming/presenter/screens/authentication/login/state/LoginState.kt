package com.compose.moviestreaming.presenter.screens.authentication.login.state

import com.compose.moviestreaming.core.enums.feedback.FeedbackType

data class LoginState(

    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = "",
    val passwordVisibility: Boolean = false,
    val enableSignInButton: Boolean = false,
    val hasError: Boolean = false,
    val feedbackUI: Pair<FeedbackType,Int>? = null

)
