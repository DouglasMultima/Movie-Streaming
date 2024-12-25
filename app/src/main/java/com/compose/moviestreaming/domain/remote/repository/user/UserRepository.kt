package com.compose.moviestreaming.domain.remote.repository.user

import com.compose.moviestreaming.domain.remote.model.User

interface UserRepository {

    suspend fun save(user:User){

    }
}