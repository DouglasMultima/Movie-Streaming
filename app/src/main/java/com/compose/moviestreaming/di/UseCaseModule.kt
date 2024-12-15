package com.compose.moviestreaming.di

import com.compose.moviestreaming.domain.remote.usecase.authentication.RegisterUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { RegisterUseCase(get()) }
}