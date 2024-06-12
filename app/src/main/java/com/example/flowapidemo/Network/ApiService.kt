package com.example.flowapidemo.Network

import com.example.flowapidemo.Model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPost():List<Post>
}