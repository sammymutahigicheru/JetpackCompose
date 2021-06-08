package com.sammy.jetpackcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sammy.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                NewNames()
            }
        }
    }

    @Composable
    fun MyApp(content: @Composable () -> Unit) {
        JetpackComposeTheme {
            Surface(color = Color.LightGray) {
                content()
            }
        }
    }

    @Composable
    fun NewNames(names: List<String> = List(100) { "Hello $it" }) {
        val counterState = remember { mutableStateOf(0) }
        Column(
            modifier = Modifier.fillMaxHeight()
        ) {
            NameList(names, Modifier.weight(1f))
            Counter(
                count = counterState.value,
                updateCount = { newCount ->
                    counterState.value = newCount
                }
            )
        }

    }

    @Composable
    fun NameList(names: List<String>, modifier: Modifier = Modifier) {
        LazyColumn(modifier = modifier) {
            items(items = names) { name ->
                DisplayName(name)
                Divider(color = Color.Black)
            }
        }
    }

    @Composable
    fun DisplayName(name: String) {
        var isSelected by remember { mutableStateOf(false) }
        val backgroundColor by animateColorAsState(if (isSelected) Color.Red else Color.Transparent)

        Text(
            text = "Hello $name!",
            modifier = Modifier
                .padding(24.dp)
                .background(color = backgroundColor)
                .clickable(onClick = { isSelected = !isSelected })
        )
    }

    @Composable
    fun Counter(
        count: Int, updateCount: (Int) -> Unit
    ) {
        Button(
            onClick = { updateCount(count + 1) },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (count > 5) Color.Green else Color.White
            )
        ) {
            Text(text = "I have clicked $count times")
        }
    }

    @Preview(showBackground = true, name = "Text Preview")
    @Composable
    fun DefaultPreview() {
        NewNames()
    }

}