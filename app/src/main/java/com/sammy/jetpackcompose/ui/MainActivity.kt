package com.sammy.jetpackcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.sammy.jetpackcompose.JetpackComposeApp
import com.sammy.jetpackcompose.ui.home.CustomerViewModel
import com.sammy.jetpackcompose.ui.theme.JetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<CustomerViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Handle fitting system windows
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            JetpackComposeTheme {
                ProvideWindowInsets {
                    JetpackComposeApp()
                }
            }
        }
    }

}
