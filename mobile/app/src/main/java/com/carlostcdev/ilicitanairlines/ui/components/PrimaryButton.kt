package com.carlostcdev.ilicitanairlines.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.carlostcdev.ilicitanairlines.ui.theme.AppShapes
import com.carlostcdev.ilicitanairlines.ui.theme.AppTextSizes
import com.carlostcdev.ilicitanairlines.ui.theme.Palette

@Composable
fun PrimaryButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier.fillMaxWidth(),
        shape = AppShapes.button,
        colors = buttonColors(
            containerColor = Palette.primary,
            contentColor = Palette.white,
            disabledContainerColor = Palette.gray,
            disabledContentColor = Palette.white
        )
    ) {
        Text(
            text = label,
            fontSize = AppTextSizes.xxlarge,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() = PrimaryButton(
    "Button",
    {}
)