package com.hello.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Dashboard
import androidx.compose.material.icons.rounded.Money
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hello.viewmodel.VendorViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(vendorViewModel: VendorViewModel, navHostController: NavHostController) {
    val bottomNavigationItemIndex = remember {
        mutableStateOf(BottomNavigationItem.Dashboard.route)
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .weight(0.95f)
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                when (bottomNavigationItemIndex.value) {
                    BottomNavigationItem.Dashboard.route -> {
                        Text(text = "Dashboard")
                    }

                    BottomNavigationItem.Sales.route -> {
                        Text(text = "Sales")
                    }

                    BottomNavigationItem.Orders.route -> {
                        Orders(
                            vendorViewModel = vendorViewModel,
                            navHostController = navHostController
                        )
                    }

                    BottomNavigationItem.Profile.route -> {
                        Text(text = "Profile")
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .weight(0.05f)
                .fillMaxWidth()
        ) {
            // Add your navigation bar here
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Rounded.Dashboard, contentDescription = null,
                    modifier = Modifier.clickable {
                        bottomNavigationItemIndex.value = BottomNavigationItem.Dashboard.route
                    }
                )
                Icon(imageVector = Icons.Rounded.Money, contentDescription = null,
                    modifier = Modifier.clickable {
                        bottomNavigationItemIndex.value = BottomNavigationItem.Sales.route
                    }
                )
                Icon(imageVector = Icons.Rounded.ShoppingCart, contentDescription = null,
                    modifier = Modifier.clickable {
                        bottomNavigationItemIndex.value = BottomNavigationItem.Orders.route
                    }
                )
                Icon(imageVector = Icons.Rounded.Person, contentDescription = null,
                    modifier = Modifier.clickable {
                        bottomNavigationItemIndex.value = BottomNavigationItem.Profile.route
                    }
                )

            }
        }
    }

}

sealed class BottomNavigationItem(var route: String) {
    object Dashboard : BottomNavigationItem("Dashboard")
    object Sales : BottomNavigationItem("Sales")
    object Orders : BottomNavigationItem("Orders")
    object Profile : BottomNavigationItem("Profile")
}

//@Preview(showBackground = true)
//@Composable
//private fun HomeScreenPreview() {
//    HomeScreen(vendorViewModel = VendorViewModel(), navHostController = rememberNavController())
//}