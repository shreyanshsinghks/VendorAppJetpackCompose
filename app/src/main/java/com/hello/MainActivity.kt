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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.compose.rememberNavController
import com.hello.navigation.NavGraph
import com.hello.viewmodel.VendorViewModel
import com.hello.ui.theme.VenderAppTheme

class MainActivity : ComponentActivity() {
        private val vendorViewModel by viewModels<VendorViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return VendorViewModel(applicationContext) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
//        val vendorViewModel = ViewModelProvider(this).get(VendorViewModel::class)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController = rememberNavController()
            VenderAppTheme {
                Scaffold {
                    Surface(modifier = Modifier.padding(it)) {
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