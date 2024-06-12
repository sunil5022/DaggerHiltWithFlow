package com.example.flowapidemo.Network

import com.example.flowapidemo.Model.Post
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiService:ApiService) {
    suspend fun getPost():List<Post> = apiService.getPost()

}