package com.compose.moviestreaming.di

import com.compose.moviestreaming.data.remote.repository.authentication.SignupRepositoryImpl
import com.compose.moviestreaming.domain.remote.repository.authentication.SignupRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory <SignupRepository> { SignupRepositoryImpl() }
}