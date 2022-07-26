package com.danielg7.cripto

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.danielg7.cripto.domain.viewmodels.CriptoViewModel
import com.danielg7.cripto.ui.components.CriptoCard
import com.danielg7.cripto.ui.theme.CriptoTheme
import com.danielg7.cripto.utils.hasInternetConnection
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val vm: CriptoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm.getCriptos(onSuccess = {
            Timber.v(it.size.toString())
        },
            onError = {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            },
            refresh = hasInternetConnection()
        )

        setContent {
            CriptoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Cripto") }
                        )
                    },
                    bottomBar = {
                        BottomAppBar { /* Bottom app bar content */ }
                    }
                ) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(vm.criptos) { item ->
                            CriptoCard(item, onClick = {
                            })
                        }
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show()
    }
}
