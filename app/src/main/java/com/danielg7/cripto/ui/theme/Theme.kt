package com.danielg7.cripto.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = BlueGray400,
    primaryVariant = BlueGrayDark,
    secondary = Cyan800
)

private val LightColorPalette = lightColors(
    primary = BlueGrayDark,
    primaryVariant = BlueGrayDark,
    secondary = Cyan800

)

@Composable
fun CriptoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = CriptoTypography,
        shapes = Shapes,
        content = content
    )
}
