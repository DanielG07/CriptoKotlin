package com.danielg7.traders.ui.components.home

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.danielg7.cripto.utils.hasInternetConnection
import com.danielg7.traders.domain.viewmodels.TraderViewModel
import com.danielg7.traders.ui.theme.CriptoTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val vm: TraderViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm.getTraders(
            onSuccess = {
                Timber.v(it.size.toString())
            },
            onError = {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            },
            refresh = this.hasInternetConnection()
        )

        setContent {
            CriptoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Text(text = vm.traders.toString())
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CriptoTheme {
        Greeting("Android")
    }
}
