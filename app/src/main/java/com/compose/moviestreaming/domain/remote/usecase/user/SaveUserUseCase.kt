package com.compose.moviestreaming.domain.remote.usecase.user

import com.compose.moviestreaming.domain.remote.model.User
import com.compose.moviestreaming.domain.remote.repository.user.UserRepository

class SaveUserUseCase(
    private val repository: UserRepository
) {

    suspend operator fun invoke(user: User) {
        repository.save(user)
    }
}