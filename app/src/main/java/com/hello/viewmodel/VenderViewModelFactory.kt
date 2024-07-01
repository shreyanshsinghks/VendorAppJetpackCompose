package com.hello.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hello.pref.DataStoreManager

class VendorViewModelFactory(private val dataStoreManager: DataStoreManager) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VendorViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return VendorViewModel(dataStoreManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}