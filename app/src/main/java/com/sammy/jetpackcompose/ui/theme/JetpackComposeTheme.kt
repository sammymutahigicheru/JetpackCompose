package com.sammy.jetpackcompose.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun JetpackComposeTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = JetpackComposeColors,
        typography = JetpackComposeTypography,
        shapes = JetpackComposeShapes,
        content = content
    )
}