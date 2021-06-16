package com.sammy.jetpackcompose.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sammy.jetpackcompose.data.CustomerResponseItem
import com.sammy.jetpackcompose.ui.theme.Keyline1

@Composable
fun CustomerList(
    customers: List<CustomerResponseItem>,
    modifier: Modifier = Modifier
) {
    val lastIndex = customers.size - 1
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(start = Keyline1, top = 8.dp, end = Keyline1, bottom = 24.dp)
    ) {
        itemsIndexed(items = customers) { index: Int, customer: CustomerResponseItem ->
            CustomerRowItem(
                customer = customer,
                modifier = Modifier.width(128.dp)
            )
            if (index < lastIndex) Spacer(Modifier.width(24.dp))
        }
    }
}

@Composable
fun CustomerRowItem(
    customer: CustomerResponseItem,
    modifier: Modifier
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth(),
        elevation = 8.dp,
    ) {
        Column {
            Text(
                text = customer.customerName,
                modifier = Modifier
                    .wrapContentWidth(Alignment.Start)
                    .padding(start = 8.dp),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = customer.status,
                modifier = Modifier
                    .wrapContentWidth(Alignment.Start)
                    .padding(start = 8.dp),
            )

        }
    }

}

