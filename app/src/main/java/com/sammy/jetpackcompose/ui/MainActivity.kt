package com.sammy.jetpackcompose.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sammy.jetpackcompose.ui.components.CustomerListView
import com.sammy.jetpackcompose.ui.details.DetailsActivity
import com.sammy.jetpackcompose.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<CustomerViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getAssets()
        setContent {
            val loading = viewModel.loading.value
            val customers = viewModel.customer.value
            val scaffoldState = rememberScaffoldState()

            AppTheme(
                displayProgressBar = loading,
                scaffoldState = scaffoldState,
                darkTheme = false,
            ) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Customers")
                            },
                            navigationIcon = {
                                IconButton(onClick = { }) {
                                    Icon(
                                        imageVector = Icons.Filled.Menu,
                                        contentDescription = "Menu Btn"
                                    )
                                }
                            },
                            backgroundColor = Color.Transparent,
                            contentColor = Color.Black,
                            elevation = 2.dp
                        )
                    },
                    scaffoldState = scaffoldState,
                    snackbarHost = {
                        scaffoldState.snackbarHostState
                    }
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Column {
                            CustomerListView(
                                loading = loading,
                                customers = customers,
                                onNavigateToCustomerDetailScreen = {
                                    Intent(this@MainActivity, DetailsActivity::class.java).apply {
                                        startActivity(this)
                                    }
                                }
                            )
                        }
                    }
                }
            }

        }
    }

}
