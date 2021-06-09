package com.sammy.jetpackcompose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sammy.jetpackcompose.data.AssetsResponseItem
import com.sammy.jetpackcompose.utils.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AssetsViewModel @Inject constructor(
    private val assetsRepository: AssetsRepository
) : ViewModel() {
    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    //customer
    private val _customer: MutableStateFlow<List<AssetsResponseItem>?> = MutableStateFlow(null)
    val customer: StateFlow<List<AssetsResponseItem>?> = _customer

    fun getAssets() = viewModelScope.launch {
        _loading.value = true
        val customers = assetsRepository.getAssets()
        when (customers) {
            is ApiResponse.Success -> {
                val items = customers.value
                _customer.value = items
                _loading.value = false
            }
            is ApiResponse.Failure -> {
                _loading.value = false
            }
        }
    }
}