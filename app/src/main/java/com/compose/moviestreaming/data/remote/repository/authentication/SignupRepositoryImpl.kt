package com.compose.moviestreaming.data.remote.repository.authentication

import com.compose.moviestreaming.core.helper.FirebaseHelper
import com.compose.moviestreaming.domain.remote.repository.authentication.SignupRepository
import com.google.firebase.auth.FirebaseAuth
import kotlin.coroutines.suspendCoroutine

class SignupRepositoryImpl: SignupRepository {

    override suspend fun register(email: String, password: String) {
        return suspendCoroutine {continuation ->
            FirebaseHelper.getAuth().createUserWithEmailAndPassword(email, password)
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