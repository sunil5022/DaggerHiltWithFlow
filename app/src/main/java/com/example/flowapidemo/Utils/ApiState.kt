package com.example.flowapidemo.Utils

import com.example.flowapidemo.Model.Post

sealed class ApiState{
    object Loading : ApiState()
    class Failure(val msg:Throwable) : ApiState()
    class Success(val data:List<Post>) : ApiState()
    object Empty : ApiState()
}
