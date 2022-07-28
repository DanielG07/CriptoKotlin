package com.danielg7.cripto.ui.atm

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import com.danielg7.cripto.ui.theme.CriptoTheme
import com.google.maps.android.compose.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AtmActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CriptoTheme {
                Map()
            }
        }
    }

    companion object {

        fun getIntent(context: Context): Intent {
            val intent = Intent(
                context,
                AtmActivity::class.java
            )
            /*.addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
            )*/
            return intent
        }
    }
}
