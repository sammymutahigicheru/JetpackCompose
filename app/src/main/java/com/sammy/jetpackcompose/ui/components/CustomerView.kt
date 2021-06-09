package com.sammy.jetpackcompose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sammy.jetpackcompose.data.AssetsResponseItem

@Composable
fun CustomerView(
    customer: AssetsResponseItem,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp)
        ) {
            Text(
                text = customer.customerName,
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .wrapContentWidth(Alignment.Start),
                style = MaterialTheme.typography.h3
            )
            Text(
                text = customer.deliveryPointName,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End)
                    .align(Alignment.CenterVertically),
                style = MaterialTheme.typography.h5
            )
        }
        Text(
            text = customer.salesAreaName,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            style = MaterialTheme.typography.caption
        )
        Text(
            text = customer.status,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            style = MaterialTheme.typography.body1
        )
    }
}