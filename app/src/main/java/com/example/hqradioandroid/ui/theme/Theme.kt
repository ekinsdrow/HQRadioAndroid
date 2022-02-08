package com.example.hqradioandroid.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = TextColor,
    primaryVariant = BgColor,
    secondary = BgColor
)

private val LightColorPalette = lightColors(
    primary = BgColor,
    primaryVariant = BgColor,
    secondary = BgColor,
    background = BgColor,
    surface = BgColor
)

@Composable
fun HqRadioAndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content,
    )
}