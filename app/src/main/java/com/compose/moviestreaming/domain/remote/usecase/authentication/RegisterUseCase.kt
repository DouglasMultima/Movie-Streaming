package com.compose.moviestreaming.domain.remote.usecase.authentication

import com.compose.moviestreaming.domain.remote.repository.authentication.SignupRepository

class RegisterUseCase(
    private val repository : SignupRepository
) {
    suspend operator fun invoke(email: String, password: String){
        repository.register(email, password)
    }

}