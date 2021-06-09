package com.sammy.jetpackcompose.ui

import com.sammy.jetpackcompose.data.base.BaseRepository
import com.sammy.jetpackcompose.network.ApiService
import javax.inject.Inject

class AssetsRepository @Inject constructor(
    private val apiService: ApiService
) : BaseRepository() {
    suspend fun getAssets() = apiCall {
        apiService.getAllAssets()
    }
}