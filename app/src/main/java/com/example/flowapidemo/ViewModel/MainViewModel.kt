package com.example.flowapidemo.ViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flowapidemo.Repository.MainRepository
import com.example.flowapidemo.Utils.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
public class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel(){

    private val postStateFlow: MutableStateFlow<ApiState>
            = MutableStateFlow(ApiState.Empty)

    val _postStateFlow: StateFlow<ApiState> = postStateFlow

    fun getPost() = viewModelScope.launch {
        postStateFlow.value = ApiState.Loading
        mainRepository.getPost()
            .catch { e->
                postStateFlow.value=ApiState.Failure(e)
            }.collect { data->
                postStateFlow.value=ApiState.Success(data)
            }
    }}