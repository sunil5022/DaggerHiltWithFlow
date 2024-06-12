//package com.example.flowapidemo.ViewModel
//
//import android.app.Application
//import androidx.lifecycle.AbstractSavedStateViewModelFactory
//import androidx.lifecycle.SavedStateHandle
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import androidx.savedstate.SavedStateRegistryOwner
//import com.example.flowapidemo.Repository.MainRepository
//
//
//class MyViewModelFactory( savedStateRegistryOwner: SavedStateRegistryOwner,
//                          application: Application,
//                          private val repository: MainRepository
//) : AbstractSavedStateViewModelFactory(savedStateRegistryOwner, null) {
//
//    override fun <T : ViewModel> create(
//        key: String,
//        modelClass: Class<T>,
//        handle: SavedStateHandle
//    ): T {
//        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
//            return MainViewModel(handle, repository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}class