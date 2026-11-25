package com.carlostcdev.ilicitanairlines.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.carlostcdev.ilicitanairlines.R

val IlicitanSans = FontFamily(
    Font(R.font.ilicitan_sans_regular, FontWeight.Normal),
    Font(R.font.ilicitan_sans_medium, FontWeight.Medium),
    Font(R.font.ilicitan_sans_semibold, FontWeight.SemiBold),
    Font(R.font.ilicitan_sans_bold, FontWeight.Bold)
)

val AppTypography = Typography(
    displayLarge = TextStyle(fontFamily = IlicitanSans),
    displayMedium = TextStyle(fontFamily = IlicitanSans),
    displaySmall = TextStyle(fontFamily = IlicitanSans),
    headlineLarge = TextStyle(fontFamily = IlicitanSans),
    headlineMedium = TextStyle(fontFamily = IlicitanSans),
    headlineSmall = TextStyle(fontFamily = IlicitanSans),
    titleLarge = TextStyle(fontFamily = IlicitanSans),
    titleMedium = TextStyle(fontFamily = IlicitanSans),
    titleSmall = TextStyle(fontFamily = IlicitanSans),
    bodyLarge = TextStyle(fontFamily = IlicitanSans),
    bodyMedium = TextStyle(fontFamily = IlicitanSans),
    bodySmall = TextStyle(fontFamily = IlicitanSans),
    labelLarge = TextStyle(fontFamily = IlicitanSans),
    labelMedium = TextStyle(fontFamily = IlicitanSans),
    labelSmall = TextStyle(fontFamily = IlicitanSans)
)