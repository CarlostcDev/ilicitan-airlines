package com.carlostcdev.ilicitanairlines.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors(
            containerColor = Palette.primary,
            contentColor = Palette.white,
            disabledContainerColor = Palette.gray,
            disabledContentColor = Palette.white
        )
    ) {
        Text(
            text = label,
            fontSize = 20.sp
        )
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() = PrimaryButton(
    "Button",
    {}
)