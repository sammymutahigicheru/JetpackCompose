package com.sammy.jetpackcompose.ui

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
    private val _state = MutableStateFlow(HomeViewState())

    val state: StateFlow<HomeViewState>
        get() = _state

    init {
        viewModelScope.launch {
            _state.value.refreshing = true
            when (val response = customerRepository.getAssets()) {
                is ApiResponse.Success -> {
                    val customers = response.value
                    _state.value.customers = customers
                    _state.value.refreshing = false
                }
                is ApiResponse.Failure -> {
                    _state.value.errorMessage = response.errorHolder.message
                    _state.value.refreshing = false
                }
            }
        }
    }
}

data class HomeViewState(
    var customers: List<CustomerResponseItem> = emptyList(),
    var refreshing: Boolean = false,
    var errorMessage: String? = null
)