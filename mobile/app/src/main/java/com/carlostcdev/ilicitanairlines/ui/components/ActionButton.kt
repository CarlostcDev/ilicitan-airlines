package com.carlostcdev.ilicitanairlines.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carlostcdev.ilicitanairlines.ui.enums.ButtonType
import com.carlostcdev.ilicitanairlines.ui.theme.AppDimensions
import com.carlostcdev.ilicitanairlines.ui.theme.AppShapes
import com.carlostcdev.ilicitanairlines.ui.theme.AppSpacing
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
                    disabledContainerColor = IlicitanColors.Button.primaryDisabled,
                    disabledContentColor = IlicitanColors.Button.contentDisabled
                )
            ) {
                Text(
                    text = label,
                    fontSize = AppTextSizes.large,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(AppSpacing.small)
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
                    disabledContainerColor = IlicitanColors.Button.secondaryDisabled,
                    disabledContentColor = IlicitanColors.Button.contentDisabled
                ),
                border = if (enabled) BorderStroke(AppDimensions.borderWidth, IlicitanColors.Button.default) else null
            ) {
                Text(
                    text = label,
                    fontSize = AppTextSizes.large,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(AppSpacing.small)
                )
            }
    }
}

@Preview
@Composable
fun ActionButtonPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        ActionButton(
            label = "Primary Enabled",
            onClick = {},
            buttonType = ButtonType.PRIMARY
        )
        ActionButton(
            label = "Primary Disabled",
            onClick = {},
            enabled = false,
            buttonType = ButtonType.PRIMARY
        )
        ActionButton(
            label = "Secondary Enabled",
            onClick = {},
            buttonType = ButtonType.SECONDARY
        )
        ActionButton(
            label = "Secondary Disabled",
            onClick = {},
            enabled = false,
            buttonType = ButtonType.SECONDARY
        )
    }
}