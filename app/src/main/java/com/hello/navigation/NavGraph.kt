package com.hello.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hello.screens.HomeScreen.Home
import com.hello.screens.signUpPage.SignUpScreen
import com.hello.screens.signUpPage.SignUpScreenViewModel

@Composable
fun NavGraph(signUpScreenViewModel: SignUpScreenViewModel, navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = Routes.Home) {

        composable<Routes.SignUpScreen> {
            SignUpScreen(signUpScreenViewModel, navHostController = navHostController)
        }

        composable<Routes.Home> {
            Home(navHostController = navHostController)
        }
    }
}