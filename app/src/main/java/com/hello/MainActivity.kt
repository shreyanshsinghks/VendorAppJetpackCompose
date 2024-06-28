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
import androidx.navigation.compose.rememberNavController
import com.hello.navigation.NavGraph
import com.hello.viewmodel.VendorViewModel
import com.hello.ui.theme.VenderAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val vendorViewModel: VendorViewModel by viewModels()
            val navHostController = rememberNavController()
            VenderAppTheme {
                Scaffold {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {
                        NavGraph(
                            vendorViewModel = vendorViewModel,
                            navHostController = navHostController
                        )
                    }
                }
            }
        }
    }
}