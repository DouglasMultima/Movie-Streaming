package com.compose.moviestreaming.di

import com.compose.moviestreaming.domain.remote.usecase.authentication.RegisterUseCase
import com.compose.moviestreaming.domain.remote.usecase.user.SaveUserUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { RegisterUseCase(get()) }
    factory { SaveUserUseCase(get()) }

}