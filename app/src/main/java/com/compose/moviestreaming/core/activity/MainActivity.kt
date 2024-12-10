package com.compose.moviestreaming.core.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.compose.moviestreaming.presenter.screens.authentication.signup.screen.SignupScreen
import com.compose.moviestreaming.ui.theme.MovieStreamingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.light(
                android.graphics.Color.WHITE,
                android.graphics.Color.WHITE
            )
        )


        setContent {
            MovieStreamingTheme {
              Scaffold(
                  content = {paddingValues ->
                      Box(
                          modifier = Modifier
                              .fillMaxSize()
                              //.padding(paddingValues)

                      ){
                          SignupScreen(onBackPressed ={})


                      }
                  }
              )




            }
        }
    }
}

