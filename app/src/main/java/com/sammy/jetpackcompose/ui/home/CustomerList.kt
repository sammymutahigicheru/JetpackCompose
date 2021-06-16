package com.sammy.jetpackcompose.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.sammy.jetpackcompose.data.CustomerResponseItem
import com.sammy.jetpackcompose.ui.theme.Keyline1

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
    Column(modifier) {
        Box(
            Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = customer.customerName,
                style = MaterialTheme.typography.body2,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = customer.status,
                style = MaterialTheme.typography.body2,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
            )
        }
    }

}

