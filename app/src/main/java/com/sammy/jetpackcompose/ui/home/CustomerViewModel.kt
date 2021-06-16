package com.sammy.jetpackcompose.ui.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sammy.jetpackcompose.data.CustomerResponseItem
import com.sammy.jetpackcompose.utils.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CustomerViewModel @Inject constructor(
    private val customerRepository: CustomerRepository
) : ViewModel() {

    //customer
    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean>
        get() = _loading
    val customer: MutableState<List<CustomerResponseItem>> = mutableStateOf(ArrayList())

    fun getCustomers() = viewModelScope.launch {
        _loading.value = true
        val customers = customerRepository.getAssets()
        when (customers) {
            is ApiResponse.Success -> {
                val items = customers.value
                customer.value = items
                _loading.value = false
            }
            is ApiResponse.Failure -> {
                _loading.value = false
            }
        }
    }
}