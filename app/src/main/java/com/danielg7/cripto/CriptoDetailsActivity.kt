package com.danielg7.cripto

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.danielg7.cripto.data.remote.models.Cripto
import com.danielg7.cripto.ui.theme.CriptoTheme

class CriptoDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val criptoExtra = intent.extras?.getParcelable<Cripto>(CRIPTO_KEY)

        setContent {
            CriptoTheme {
                // A surface container using the 'background' color from the theme
                if (criptoExtra != null)
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        Greeting2("${criptoExtra.book}")
                    }
            }
        }
    }

    companion object {
        const val CRIPTO_KEY = "CRIPTO_KEY"

        fun getIntent(context: Context, cripto: Cripto?): Intent {
            val intent = Intent(
                context,
                CriptoDetailsActivity::class.java
            )
            val bundle = Bundle().apply {
                putParcelable(CRIPTO_KEY, cripto)
            }
            intent.putExtras(bundle)
            return intent
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    CriptoTheme {
        Greeting2("Android")
    }
}
