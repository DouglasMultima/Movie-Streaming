package com.compose.moviestreaming.presenter.screens.authentication.login.viewmodel



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.moviestreaming.core.enums.feedback.FeedbackType
import com.compose.moviestreaming.core.enums.input.InputType
import com.compose.moviestreaming.core.enums.input.InputType.EMAIL
import com.compose.moviestreaming.core.enums.input.InputType.PASSWORD
import com.compose.moviestreaming.core.functions.isValidEmail
import com.compose.moviestreaming.core.helper.FirebaseHelper
import com.compose.moviestreaming.presenter.screens.authentication.login.action.LoginAction
import com.compose.moviestreaming.presenter.screens.authentication.login.state.LoginState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel (

): ViewModel(

) {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()


    fun submitAction(action: LoginAction) {
        when (action) {
            is LoginAction.OnValueChange -> {
                onValueChange(action.value, action.type)
            }

            is LoginAction.OnPasswordVisibilityChange -> {
                onPasswordVisibilityChange()

            }

           is LoginAction.OnSignIn -> {
                onSignIn()
           }

           is LoginAction.ResetError -> {
               resetError()
           }
        }
    }

    private fun onSignIn() {
        viewModelScope.launch {
           try {

//               registerUseCase(
//                   email = state.value.email,
//                   password = state.value.password
//               )
//
//               saveUserUseCase(user = User(email = state.value.email))


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
        enableSignInButton()
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

    private fun enableSignInButton() {
        val emailValid =isValidEmail(_state.value.email)
        val passwordValid = _state.value.email.isNotBlank()

        _state.update { currentState ->
            currentState.copy(enableSignInButton = emailValid && passwordValid)

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

