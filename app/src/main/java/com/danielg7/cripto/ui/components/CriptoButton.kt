package com.danielg7.cripto.ui.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.danielg7.cripto.ui.theme.CriptoTheme

@Composable
fun CriptoButton() {
    Button(onClick = { throw RuntimeException("Test Crash") }) {
        Text(text = "Presionar")
    }
}

@Preview("Cripto Button")
@Composable
fun CriptoButtonPreview() {
    CriptoTheme {
        CriptoButton()
    }
}

@Preview("Cripto Button - Dark")
@Composable
fun CriptoButtonPreviewDark() {
    CriptoTheme(darkTheme = true) {
        CriptoButton()
    }
}