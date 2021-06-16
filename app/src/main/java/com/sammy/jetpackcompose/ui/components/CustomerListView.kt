//package com.sammy.jetpackcompose.ui.components
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material.MaterialTheme
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import com.sammy.jetpackcompose.data.CustomerResponseItem
//
//@Composable
//fun CustomerListView(
//    loading: Boolean,
//    customers: List<CustomerResponseItem>,
//    onNavigateToCustomerDetailScreen: (CustomerResponseItem) -> Unit
//) {
//    Box(
//        modifier = Modifier
//            .background(color = MaterialTheme.colors.surface)
//    ) {
//        if (loading && customers.isEmpty()) {
//            HorizontalDottedProgressBar()
//        } else if (customers.isEmpty()) {
//            NothingHere()
//        } else {
//            LazyColumn {
//                items(
//                    items = customers
//                ) { customer ->
//                    CustomerView(
//                        customer = customer,
//                        onNavigateToCustomerDetailScreen
//                    )
//                }
//            }
//        }
//    }
//}