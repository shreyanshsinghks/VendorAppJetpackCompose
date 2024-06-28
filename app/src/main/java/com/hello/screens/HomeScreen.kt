package com.hello.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.hello.viewmodel.VendorViewModel

@Composable
fun HomeScreen(vendorViewModel: VendorViewModel, navHostController: NavHostController) {
    Text(text = "Hello how are you!")
}