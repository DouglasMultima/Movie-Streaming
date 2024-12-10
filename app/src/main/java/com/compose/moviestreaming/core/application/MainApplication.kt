package com.compose.moviestreaming.core.application

import android.app.Application
import com.compose.moviestreaming.presenter.screens.authentication.signup.viewmodel.SignupRepository
import com.compose.moviestreaming.presenter.screens.authentication.signup.viewmodel.SignupRepositoryImpl
import com.compose.moviestreaming.presenter.screens.authentication.signup.viewmodel.SignupViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidLogger()
            androidContext(this@MainApplication)
            modules(presenterModule,dataModule)
        }
    }
}

val dataModule = module {
    single<SignupRepository> { SignupRepositoryImpl() }

}

val presenterModule = module {
    viewModel{ SignupViewModel(repository = get()) }
}