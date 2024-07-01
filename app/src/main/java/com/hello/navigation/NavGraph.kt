package com.hello.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hello.screens.HomeScreen
import com.hello.screens.SignUpScreen
import com.hello.viewmodel.VendorViewModel

@Composable
fun NavGraph(vendorViewModel: VendorViewModel, navHostController: NavHostController) {

    val userId by vendorViewModel.userId.collectAsState()

    NavHost(
        navController = navHostController, startDestination = if(userId == 0){Routes.SignUpScreen} else Routes.HomeScreen
    ) {

        composable<Routes.SignUpScreen> {
            SignUpScreen(vendorViewModel = vendorViewModel, navHostController = navHostController)
        }

        composable<Routes.HomeScreen> {
            HomeScreen(vendorViewModel = vendorViewModel, navHostController = navHostController)
        }
    }
    Log.d("NavGraph", "After NavHost - userId: $userId")

}