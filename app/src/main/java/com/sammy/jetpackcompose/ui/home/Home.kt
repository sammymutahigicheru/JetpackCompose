package com.sammy.jetpackcompose.ui.home

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sammy.jetpackcompose.data.CustomerResponseItem
import com.sammy.jetpackcompose.ui.CustomerViewModel
import com.sammy.jetpackcompose.ui.components.HorizontalDottedProgressBar

@Composable
fun Home() {
    val homeViewModel = viewModel(CustomerViewModel::class.java)
    val viewState by homeViewModel.state.collectAsState()
    Surface(Modifier.fillMaxHeight()) {
        HomeContent(
            isRefreshing = viewState.refreshing,
            customers = viewState.customers,
            errorMessage = viewState.errorMessage
        )
    }
}

@Composable
fun HomeContent(
    isRefreshing: Boolean,
    customers: List<CustomerResponseItem>,
    errorMessage: String?
) {
    when {
        isRefreshing -> {
            HorizontalDottedProgressBar()
        }
        customers.isNullOrEmpty() -> {

        }
        errorMessage!!.isNotEmpty() -> {

        }
    }
    CustomerList(customers = customers)
}
