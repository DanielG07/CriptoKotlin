package com.danielg7.cripto

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.danielg7.cripto.tutorial.*
import com.danielg7.cripto.ui.components.CriptoButton
import com.danielg7.cripto.ui.theme.CriptoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CriptoTheme {
             CriptoButton()
            }
        }
    }
}


