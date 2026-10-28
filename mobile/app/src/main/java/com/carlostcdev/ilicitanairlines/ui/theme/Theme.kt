package com.carlostcdev.ilicitanairlines.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = Palette.primary,
    onPrimary = Palette.white,
    secondary = Palette.secondary,
    onSecondary = Palette.white,
    tertiary = Palette.success,
    onTertiary = Palette.white,
    background = Palette.lightGray,
    onBackground = Palette.black,
    surface = Palette.white,
    onSurface = Palette.black,
    error = Palette.error,
    onError = Palette.white,
    outline = Palette.gray
)

@Composable
fun IlicitanAirlinesTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}