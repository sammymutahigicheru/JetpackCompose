package com.sammy.jetpackcompose.ui.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sammy.jetpackcompose.data.CustomerResponseItem
import com.sammy.jetpackcompose.ui.CustomerViewModel
import com.sammy.jetpackcompose.utils.verticalGradientScrim

@Composable
fun Home() {
    val homeViewModel = viewModel(CustomerViewModel::class.java)
    val viewState by homeViewModel.state.collectAsState()
    Surface(Modifier.fillMaxHeight()) {
        Log.e("", "Customers: ${viewState.customers}")
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
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalGradientScrim(
                color = MaterialTheme.colors.primary.copy(alpha = 0.38f),
                startYPercentage = 1f,
                endYPercentage = 0f
            )
    ) {

    }
}
