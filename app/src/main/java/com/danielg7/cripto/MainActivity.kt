package com.danielg7.cripto

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.danielg7.cripto.domain.viewmodels.CriptoViewModel
import com.danielg7.cripto.ui.components.CriptoButton
import com.danielg7.cripto.ui.theme.CriptoTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val vm: CriptoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show()

        setContent {
            CriptoTheme {
                CriptoButton()
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

        vm.getCriptos(onSuccess = {
            Timber.v(it.size.toString())
            Toast.makeText(this, it.size.toString(), Toast.LENGTH_SHORT).show()
        },
            onError = {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            })
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show()
    }
}
