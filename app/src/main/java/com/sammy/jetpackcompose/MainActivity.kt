package com.sammy.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            NewsStroy()
        }
    }
    @Composable
    fun NewsStroy(){
        Text(text = "A day in shark fin cove")
        Text(text = "Davenport, California")
        Text(text = "December 2018")
    }

    @Preview
    @Composable
    fun PreviewNewStory(){
        NewsStroy()
    }

}