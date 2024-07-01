package com.hello.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hello.api.ProductDataClassItem
import com.hello.api.RetrofitInstance
import com.hello.pref.UserPrefImp
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import perfetto.protos.UiState

class VendorViewModel(val context: Context) : ViewModel() {

    var state = mutableStateOf("")
    var products = mutableStateOf<List<ProductDataClassItem?>>(emptyList())
    private val datastore = PreferenceDataStoreFactory.create(
        corruptionHandler = ReplaceFileCorruptionHandler(
            produceNewData = { emptyPreferences() }
        ),
        produceFile = { context.preferencesDataStoreFile("user_data") }
    )

    private val userPref = UserPrefImp(datastore)


    private val _userId = MutableStateFlow(0)
    val userId = _userId.asStateFlow()

    init {
        state.value = State.DEFAULT.name
        viewModelScope.launch {
            products.value = RetrofitInstance.api.getAllProducts()
            userPref.getPref().collect {
                _userId.value = it
            }
        }
    }

    fun savePref(id: Int){
        viewModelScope.launch {
            userPref.setPref(id)
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
                    savePref(151)
                    delay(300)
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