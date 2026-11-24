package com.carlostcdev.ilicitanairlines.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.carlostcdev.ilicitanairlines.ui.enums.ButtonType
import com.carlostcdev.ilicitanairlines.ui.theme.AppDimensions
import com.carlostcdev.ilicitanairlines.ui.theme.AppShapes
import com.carlostcdev.ilicitanairlines.ui.theme.AppTextSizes
import com.carlostcdev.ilicitanairlines.ui.theme.IlicitanColors

@Composable
fun ActionButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    buttonType: ButtonType = ButtonType.PRIMARY,
    enabled: Boolean = true
) {
    when (buttonType) {
        ButtonType.PRIMARY ->
            Button(
                onClick = onClick,
                enabled = enabled,
                modifier = modifier.fillMaxWidth(),
                shape = AppShapes.button,
                colors = ButtonDefaults.buttonColors(
                    containerColor = IlicitanColors.Button.default,
                    contentColor = IlicitanColors.Text.hover,
                    disabledContainerColor = IlicitanColors.Button.disabled,
                    disabledContentColor = IlicitanColors.Text.disabled
                )
            ) {
                Text(
                    text = label,
                    fontSize = AppTextSizes.xxlarge,
                    fontWeight = FontWeight.Bold
                )
            }

        ButtonType.SECONDARY ->
            OutlinedButton(
                onClick = onClick,
                enabled = enabled,
                modifier = modifier.fillMaxWidth(),
                shape = AppShapes.button,
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = IlicitanColors.Text.secondary,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = IlicitanColors.Text.disabled
                ),
                border = BorderStroke(
                    AppDimensions.borderWidth,
                    if (enabled) IlicitanColors.Button.default else IlicitanColors.Button.disabled
                )
            ) {
                Text(
                    text = label,
                    fontSize = AppTextSizes.xxlarge,
                    fontWeight = FontWeight.Bold
                )
            }
    }
}

@Preview
@Composable
fun ActionButtonPreview() {
    Column {
        ActionButton(
            label = "Primary",
            onClick = {},
            buttonType = ButtonType.PRIMARY
        )
        ActionButton(
            label = "Secondary",
            onClick = {},
            buttonType = ButtonType.SECONDARY
        )
    }
}