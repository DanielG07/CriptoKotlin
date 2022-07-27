package com.danielg7.cripto.ui.atm

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.danielg7.cripto.R
import com.danielg7.cripto.ui.theme.CriptoTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.*

class AtmActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CriptoTheme {
                val singapore = LatLng(1.35, 103.87)
                val cameraPositionState = rememberCameraPositionState {
                    position = CameraPosition.fromLatLngZoom(singapore, 10f)
                }
                val mapProperties by remember {
                    mutableStateOf(
                        MapProperties(
                            mapType = MapType.NORMAL,
                            mapStyleOptions = MapStyleOptions.loadRawResourceStyle(
                                this, R.raw.map_style
                            )
                        )
                    )
                }
                GoogleMap(
                    modifier = Modifier.fillMaxSize(),
                    cameraPositionState = cameraPositionState,
                    properties = mapProperties
                ) {
                    Marker(
                        position = singapore,
                        title = "Singapore",
                        snippet = "Marker in Singapore"
                    )
                }
            }
        }
    }

    companion object {

        fun getIntent(context: Context): Intent {
            val intent = Intent(
                context,
                AtmActivity::class.java
            )
            intent.addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
            )
            return intent
        }
    }
}
