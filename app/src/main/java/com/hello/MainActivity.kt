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
import com.hello.pref.DataStoreManager
import com.hello.viewmodel.VendorViewModel
import com.hello.ui.theme.VenderAppTheme
import com.hello.viewmodel.VendorViewModelFactory

class MainActivity : ComponentActivity() {
    private val dataStoreManager by lazy { DataStoreManager(applicationContext) }
    private val vendorViewModel: VendorViewModel by viewModels {
        VendorViewModelFactory(dataStoreManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
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