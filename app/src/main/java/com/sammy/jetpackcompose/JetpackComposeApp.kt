package com.sammy.jetpackcompose

import android.content.Context
import android.net.ConnectivityManager
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource

@Composable
fun JetpackComposeApp() {
    val context = LocalContext.current
    var isOnline by remember { mutableStateOf(checkIfOnline(context)) }
    if (isOnline) {

    } else {
        ShowOfflineDialog { isOnline = checkIfOnline(context) }
    }
}

private fun checkIfOnline(context: Context): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = cm.activeNetworkInfo
    return activeNetwork?.isConnectedOrConnecting == true
}

@Composable
private fun ShowOfflineDialog(onRetry: () -> Unit) {
    AlertDialog(
        onDismissRequest = { },
        title = { Text(text = stringResource(R.string.connection_error)) },
        text = { Text(text = stringResource(R.string.connection_message_text)) },
        confirmButton = {
            TextButton(onClick = { onRetry }) {
                Text(text = stringResource(R.string.retry))
            }
        }
    )
}