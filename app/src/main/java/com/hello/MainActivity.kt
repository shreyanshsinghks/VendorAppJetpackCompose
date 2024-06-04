package com.hello

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.hello.screens.signUpPage.SignUpScreen
import com.hello.screens.signUpPage.SignUpScreenViewModel
import com.hello.ui.theme.VenderAppTheme

class MainActivity : ComponentActivity() {
    val viewModel: SignUpScreenViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VenderAppTheme {
                Scaffold {
                    Box(modifier = Modifier.fillMaxSize().padding(it)){
                        SignUpScreen(viewModel)
                    }
                }
            }
        }
    }
}