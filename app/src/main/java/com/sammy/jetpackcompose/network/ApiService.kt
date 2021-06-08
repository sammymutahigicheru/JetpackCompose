package com.sammy.jetpackcompose.network

import com.sammy.jetpackcompose.data.AssetsResponseItem
import retrofit2.http.GET

interface ApiService {
    @GET("/api/v1/orders.json")
    suspend fun getAllAssets(): List<AssetsResponseItem>
}