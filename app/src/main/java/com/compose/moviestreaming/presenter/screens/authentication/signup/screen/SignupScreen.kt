package com.compose.moviestreaming.presenter.screens.authentication.signup.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.moviestreaming.R
import com.compose.moviestreaming.presenter.components.button.PrimaryButton
import com.compose.moviestreaming.presenter.components.button.SocialButton
import com.compose.moviestreaming.presenter.components.divider.HorizontalDividerWithText
import com.compose.moviestreaming.presenter.components.textfield.TextFieldUI
import com.compose.moviestreaming.presenter.components.topAppBar.TopAppBarUI
import com.compose.moviestreaming.ui.theme.MovieStreamingTheme
import com.compose.moviestreaming.ui.theme.UrbanistFamily

@Composable

fun SignupScreen(
    onBackPressed: () -> Unit
){
    SignupContent(
        onBackPressed = {}
    )
}

@Composable

fun SignupContent(
    onBackPressed: () -> Unit
){

    var emailValue by remember {
        mutableStateOf("")
    }

    var passwordValue by remember {
        mutableStateOf("")
    }

    Scaffold (
        topBar = {
            TopAppBarUI(
                onClick = {}
            )
        },
        content = { paddingValues ->
            Column(
                modifier  = Modifier
                    .fillMaxSize()
                    .background(MovieStreamingTheme.colorScheme.borderColor)
                    .verticalScroll(rememberScrollState())
                    .padding(paddingValues)
                    .padding(horizontal = 24.dp, vertical = 48.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(

                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier.size(120.dp)

                )

                Spacer(modifier = Modifier.height(48.dp))

                Text(
                    text = stringResource(id = R.string.label_title_signup_screen),
                    style = TextStyle(
                        fontSize = 32.sp,
                        lineHeight = 38.4.sp,
                        fontFamily = UrbanistFamily,
                        fontWeight = FontWeight.Bold,
                        color = MovieStreamingTheme.colorScheme.textColor,
                        textAlign = TextAlign.Center
                    )

                )

                Spacer(modifier = Modifier.height(48.dp))

                TextFieldUI(
                    modifier = Modifier,
                    value = emailValue,
                    placeholder = stringResource(id = R.string.label_input_email_signup_screen),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    requireKeyboardFocus = true,
                    leadingIcon = {

                        Icon(
                            painter = painterResource(id = R.drawable.ic_email) ,
                            contentDescription = null
                        )
                    },
                    onValueChange = {
                        emailValue = it
                    },
                    singleLine = true,
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextFieldUI(
                    modifier = Modifier,
                    value = passwordValue ,
                    placeholder = stringResource(id = R.string.label_input_password_signup_screen),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    requireKeyboardFocus = true,
                    leadingIcon = {

                        Icon(
                            painter = painterResource(id = R.drawable.ic_lock_screen) ,
                            contentDescription = null
                        )
                    },
                    trailingIcon = {

                        IconButton(
                            onClick = {},
                            content = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_show) ,
                                    contentDescription = null,
                                    tint = Color.Unspecified

                                )
                            }
                        )

                    },
                    onValueChange = {
                        passwordValue = it
                    },
                    singleLine = true,
                )

                Spacer(modifier = Modifier.height(20.dp) )

                PrimaryButton(
                    onClick = {},
                    isLoading = false,
                    enabled = true,
                    text = stringResource(id = R.string.label_button_signup_screen),
                )

                Spacer(modifier = Modifier.height(20.dp))

                HorizontalDividerWithText(
                    text = stringResource(id = R.string.label_or_signup_screen)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ){

                    SocialButton(
                        icon = painterResource(id = R.drawable.ic_google),
                        isLoading = false,
                        onClick = {}
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    SocialButton(

                        icon = painterResource(id = R.drawable.ic_facebook),
                        isLoading = false,
                        onClick = {}
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    SocialButton(

                        icon = painterResource(id = R.drawable.ic_github),
                        isLoading = false,
                        onClick = {}
                    )



                }

                Spacer(modifier = Modifier.height(48.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center

                ) {

                    Text(
                        text = stringResource(id = R.string.label_sign_up_account_signup_screen),
                        style = TextStyle(

                            lineHeight = 19.6.sp,
                            fontFamily = UrbanistFamily,
                            color = MovieStreamingTheme.colorScheme.textColor,
                            textAlign = TextAlign.Right,
                            letterSpacing = 0.2.sp
                        )

                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text =  stringResource(id = R.string.label_sign_in_signup_screen),
                        style = TextStyle(

                            lineHeight = 19.6.sp,
                            fontFamily = UrbanistFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = MovieStreamingTheme.colorScheme.defaultColor,
                            textAlign = TextAlign.Right,
                            letterSpacing = 0.2.sp
                        )

                    )



                }



            }
        }
    )
}


@PreviewLightDark
@Composable

private fun SignupPreview(){
    MovieStreamingTheme{
        SignupContent(
            onBackPressed = {}
        )
    }
}