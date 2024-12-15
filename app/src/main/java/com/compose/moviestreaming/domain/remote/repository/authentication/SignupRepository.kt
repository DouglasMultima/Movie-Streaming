package com.compose.moviestreaming.domain.remote.repository.authentication

interface SignupRepository {

    suspend fun register(email: String, password: String)

}