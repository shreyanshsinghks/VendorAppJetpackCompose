package com.hello.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hello.api.ProductDataClassItem
import com.hello.api.RetrofitInstance
import kotlinx.coroutines.launch
import kotlin.math.log

class VendorViewModel : ViewModel() {
    var state = mutableStateOf("")
    var products = mutableStateOf<List<ProductDataClassItem?>>(emptyList())

    init {
        state.value = State.DEFAULT.name
        viewModelScope.launch {
            products.value = RetrofitInstance.api.getAllProducts()
        }
    }


    fun createUser(
        name: String,
        password: String,
        email: String,
        address: String,
        phoneNumber: String,
        pinCode: String,
    ) {
        state.value = State.LOADING.name
        viewModelScope.launch {
            val result = RetrofitInstance.api.createUser(
                name = name,
                password = password,
                email = email,
                address = address,
                phone = phoneNumber,
                pinCode = pinCode
            )
            if (result.isSuccessful) {
                if (result.body()?.status == 200) {
                    state.value = State.SUCCESS.name
                } else {
                    state.value = State.FAILED.name
                }
            } else {
                state.value = State.FAILED.name
            }
        }
    }
}

sealed class State(var name: String) {
    object DEFAULT : State("DEFAULT")
    object FAILED : State("FAILED")
    object SUCCESS : State("SUCCESS")
    object LOADING : State("LOADING")
}