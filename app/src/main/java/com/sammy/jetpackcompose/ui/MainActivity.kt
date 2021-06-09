package com.sammy.jetpackcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.sammy.jetpackcompose.ui.components.CustomerListView
import com.sammy.jetpackcompose.ui.components.DefaultSnackbar
import com.sammy.jetpackcompose.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<AssetsViewModel>()
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
                    scaffoldState = scaffoldState,
                    snackbarHost = {
                        scaffoldState.snackbarHostState
                    }
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Column {
                            CustomerListView(loading = loading, customers = customers)
                        }
//                        CircularIndeterminateProgressBar(isDisplayed = loading, verticalBias = 0.3f)
                        DefaultSnackbar(
                            snackbarHostState = scaffoldState.snackbarHostState,
                            onDismiss = {
                                scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
                            },
                            modifier = Modifier.align(Alignment.BottomCenter)
                        )
                    }
                }
            }

        }
    }

}
