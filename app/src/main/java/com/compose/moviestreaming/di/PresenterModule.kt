package com.compose.moviestreaming.di

import com.compose.moviestreaming.presenter.screens.authentication.login.viewmodel.LoginViewModel
import com.compose.moviestreaming.presenter.screens.authentication.signup.viewmodel.SignupViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presenterModule  = module {

    viewModel {
        SignupViewModel(
        registerUseCase = get(),
        saveUserUseCase = get()

        )
    }

    viewModel {
        LoginViewModel()

    }


}