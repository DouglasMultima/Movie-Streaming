package com.compose.moviestreaming.presenter.screens.authentication.signup.viewmodel



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.moviestreaming.core.enums.feedback.FeedbackType
import com.compose.moviestreaming.core.enums.input.InputType
import com.compose.moviestreaming.core.enums.input.InputType.*
import com.compose.moviestreaming.core.functions.isValidEmail
import com.compose.moviestreaming.core.helper.FirebaseHelper
import com.compose.moviestreaming.domain.remote.model.User
import com.compose.moviestreaming.domain.remote.usecase.authentication.RegisterUseCase
import com.compose.moviestreaming.domain.remote.usecase.user.SaveUserUseCase
import com.compose.moviestreaming.presenter.screens.authentication.signup.action.SignupAction
import com.compose.moviestreaming.presenter.screens.authentication.signup.state.SignupState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignupViewModel (
    private val registerUseCase: RegisterUseCase,
    private val saveUserUseCase: SaveUserUseCase

): ViewModel(

) {

    private val _state = MutableStateFlow(SignupState())
    val state = _state.asStateFlow()


    fun submitAction(action: SignupAction) {
        when (action) {
            is SignupAction.OnValueChange -> {
                onValueChange(action.value, action.type)
            }

            is SignupAction.OnPasswordVisibilityChange -> {
                onPasswordVisibilityChange()

            }

           is SignupAction.OnSignup -> {
                onSignup()
           }

           is SignupAction.ResetError -> {
               resetError()
           }
        }
    }

    private fun onSignup() {
        viewModelScope.launch {
           try {

               registerUseCase(
                   email = state.value.email,
                   password = state.value.password
               )

               saveUserUseCase(user = User(email = state.value.email))


           }catch (exception: Exception){
               exception.printStackTrace()

               _state.update { currentState ->
                   currentState.copy(
                       hasError = true,
                       feedbackUI = Pair(FeedbackType.ERROR,FirebaseHelper.validError(exception.message))
                   )
               }

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
        val emailValid =isValidEmail(_state.value.email)
        val passwordValid = _state.value.email.isNotBlank()

        _state.update { currentState ->
            currentState.copy(enableSignupButton = emailValid && passwordValid)

        }

    }

    private fun resetError(){
        _state.update { currentState ->
            currentState.copy(
                hasError = false,
                feedbackUI = null
            )
        }
    }
}

