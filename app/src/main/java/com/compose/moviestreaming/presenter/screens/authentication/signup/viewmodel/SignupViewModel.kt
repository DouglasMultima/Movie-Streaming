package com.compose.moviestreaming.presenter.screens.authentication.signup.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.compose.moviestreaming.core.enums.InputType
import com.compose.moviestreaming.core.enums.InputType.*
import com.compose.moviestreaming.core.functions.isValidEmail
import com.compose.moviestreaming.presenter.screens.authentication.signup.action.SignupAction
import com.compose.moviestreaming.presenter.screens.authentication.signup.state.SignupState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignupViewModel(
    private val repository: SignupRepository

) : ViewModel(

) {

    private val _state = MutableStateFlow(SignupState())
    val state = _state.asStateFlow()

    init {
        repository.signup()
    }

    fun submitAction(action: SignupAction) {
        when (action) {
            is SignupAction.OnValueChange -> {
                onValueChange(action.value, action.type)
            }

            is SignupAction.OnPasswordVisibilityChange -> {
                onPasswordVisibilityChange()

            }
        }
    }

    private fun onValueChange(value: String, type: InputType) {
        when (type) {

            EMAIL -> {
                onEmailChange(value)
            }

            PASSWORD -> {
                onPasswordChange(value)
            }
        }
        enableSignupButton()
    }

    private fun onEmailChange(value: String) {
        _state.update { currentState ->
            currentState.copy(email = value)

        }
    }

    private fun onPasswordChange(value: String) {

        _state.update { currentState ->
            currentState.copy(password = value)

        }

    }

    private fun onPasswordVisibilityChange() {
        _state.update { currentState ->
            currentState.copy(passwordVisibility = !currentState.passwordVisibility)

        }
    }

    private fun enableSignupButton() {
        val emailValid = isValidEmail(_state.value.email)
        val passwordValid = _state.value.email.isNotBlank()

        _state.update { currentState ->
            currentState.copy(enableSignupButton = emailValid && passwordValid)

        }

    }
}

interface SignupRepository {
    fun signup()

}

class SignupRepositoryImpl: SignupRepository {
    override fun signup() {
        Log.i("INFOTESTE","signup")
    }
}