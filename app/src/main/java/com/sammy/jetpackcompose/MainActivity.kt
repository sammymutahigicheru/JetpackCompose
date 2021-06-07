package com.sammy.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sammy.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                NewsStroy()
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
    fun NewsStroy() {
        val counterState = remember { mutableStateOf(0) }
        Column(
            modifier = Modifier.fillMaxHeight()
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Image(
                    painter = painterResource(id = R.drawable.header),
                    contentDescription = null,
                    modifier = Modifier
                        .height(180.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop

                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "A day wandering through the sandhills " +
                            "in Shark Fin Cove, and a few of the " +
                            "sights I saw",
                    style = typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Divider(color = Color.LightGray)
                Text(
                    text = "Davenport, California",
                    style = typography.body2
                )
                Divider(color = Color.LightGray)
                Text(
                    text = "December 2018",
                    style = typography.body2
                )
                Divider(color = Color.Transparent, thickness = 32.dp)
            }
            Counter(
                count = counterState.value,
                updateCount = { newCount ->
                    counterState.value = newCount
                }
            )
        }

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
        NewsStroy()
    }

}