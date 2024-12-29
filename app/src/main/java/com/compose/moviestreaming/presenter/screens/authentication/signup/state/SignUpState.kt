package com.compose.moviestreaming.presenter.screens.authentication.signup.state

import com.compose.moviestreaming.core.enums.feedback.FeedbackType

data class SignupState(

    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = "",
    val passwordVisibility: Boolean = false,
    val enableSignupButton: Boolean = false,
    val hasError: Boolean = false,
    val feedbackUI: Pair<FeedbackType,Int>? = null

)
