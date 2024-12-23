package com.compose.moviestreaming.data.remote.repository.authentication

import com.compose.moviestreaming.domain.remote.repository.authentication.SignupRepository
import com.google.firebase.auth.FirebaseAuth
import kotlin.coroutines.suspendCoroutine

class SignupRepositoryImpl(
    private val auth: FirebaseAuth
) : SignupRepository {

    override suspend fun register(email: String, password: String) {
        return suspendCoroutine {continuation ->
            auth.createUserWithEmailAndPassword(email, password)
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