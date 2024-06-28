package com.hello.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hello.screens.HomeScreen
import com.hello.screens.SignUpScreen
import com.hello.viewmodel.VendorViewModel

@Composable
fun NavGraph(vendorViewModel: VendorViewModel, navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = Routes.HomeScreen) {

        composable<Routes.SignUpScreen> {
            SignUpScreen(vendorViewModel = vendorViewModel, navHostController = navHostController)
        }

        composable<Routes.HomeScreen> {
            HomeScreen(vendorViewModel = vendorViewModel,navHostController = navHostController)
        }
    }
}