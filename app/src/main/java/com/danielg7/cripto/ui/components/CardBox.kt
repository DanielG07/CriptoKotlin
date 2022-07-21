package com.danielg7.cripto.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danielg7.cripto.R
import com.danielg7.cripto.ui.theme.CriptoTheme

// Si importa el orden del declaración dentro del Box
@Composable
fun CardBox() {
    Box(
        modifier = Modifier
            .width(100.dp)
            .height(300.dp)
            .background(MaterialTheme.colors.primary)
    ) {
        Image(
            painter = painterResource(id = R.drawable.pexels_viktoria_stetsko_11927602),
            modifier = Modifier.align(Alignment.Center),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        Text(text = "Hola", modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Preview("Card")
@Composable
fun CardBoxPreview() {
    CriptoTheme {
        CardBox()
    }
}

@Preview("Card - Dark")
@Composable
fun CardBoxPreviewDark() {
    CriptoTheme(darkTheme = true) {
        CardBox()
    }
}