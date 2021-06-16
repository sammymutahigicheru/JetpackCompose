package com.sammy.jetpackcompose.ui.home

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sammy.jetpackcompose.ui.CustomerViewModel

@Composable
fun Home() {
    val viewModel = viewModel(CustomerViewModel::class.java)
}