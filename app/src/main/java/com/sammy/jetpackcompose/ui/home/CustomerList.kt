package com.sammy.jetpackcompose.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sammy.jetpackcompose.data.CustomerResponseItem

@Composable
fun CustomerList(
    customers: List<CustomerResponseItem>,
    modifier: Modifier = Modifier
) {
    val lastIndex = customers.size - 1
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(start = Keyline1, top = 8.dp, end = Keyline1, bottom = 24.dp)
    ) {

    }
}