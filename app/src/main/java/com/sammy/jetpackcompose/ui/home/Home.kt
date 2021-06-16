package com.sammy.jetpackcompose.ui.home

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sammy.jetpackcompose.data.CustomerResponseItem
import com.sammy.jetpackcompose.ui.components.HorizontalDottedProgressBar
import com.sammy.jetpackcompose.ui.components.NothingHere

@Composable
fun Home() {
    val homeViewModel = viewModel(CustomerViewModel::class.java)
    homeViewModel.getCustomers()
    val customers = homeViewModel.customer.value
    Surface(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        HomeContent(
            isRefreshing = homeViewModel.loading.value,
            customers = customers
        )
    }
}

@Composable
fun HomeContent(
    isRefreshing: Boolean,
    customers: List<CustomerResponseItem>
) {
    when {
        isRefreshing && customers.isEmpty() -> {
            HorizontalDottedProgressBar()
        }
        customers.isNullOrEmpty() -> {
            NothingHere()
        }
    }
    CustomerList(customers = customers)

}
