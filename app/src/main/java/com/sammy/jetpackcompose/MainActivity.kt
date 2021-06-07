package com.sammy.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            NewsStroy()
        }
    }
    @Composable
    fun NewsStroy(){
        Column(
            modifier = Modifier.padding(all = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.header),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop

            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "A day in shark fin cove")
            Text(text = "Davenport, California")
            Text(text = "December 2018")
        }

    }

    @Preview
    @Composable
    fun DefaultPreview(){
        NewsStroy()
    }

}