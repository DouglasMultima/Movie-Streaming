package com.compose.moviestreaming.data.remote.repository.user

import com.compose.moviestreaming.core.helper.FirebaseHelper
import com.compose.moviestreaming.domain.remote.model.User
import com.compose.moviestreaming.domain.remote.repository.user.UserRepository
import kotlin.coroutines.suspendCoroutine

class UserRepositoryImpl: UserRepository {

    private val usersReference = FirebaseHelper
        .getDatabase()
        .child("users")
        .child(FirebaseHelper.getUserId())

    override suspend fun save(user: User) {
        suspendCoroutine { continuation ->
            usersReference
                .setValue(user)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        continuation.resumeWith(Result.success(Unit))
                    } else {
                        task.exception?.let { exception ->
                            continuation.resumeWith(Result.failure(exception))
                        }
                    }
                }
        }

    }
}