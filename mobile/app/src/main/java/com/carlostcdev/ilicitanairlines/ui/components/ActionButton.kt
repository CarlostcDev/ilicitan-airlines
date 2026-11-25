package com.carlostcdev.ilicitanairlines.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    when (buttonType) {
        ButtonType.PRIMARY ->
            Button(
                onClick = onClick,
                enabled = enabled,
                interactionSource = interactionSource,
                modifier = modifier.fillMaxWidth(),
                shape = AppShapes.button,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isPressed) IlicitanColors.Button.primaryPressed else IlicitanColors.Button.default,
                    contentColor = IlicitanColors.Button.contentEnabled,
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
                interactionSource = interactionSource,
                modifier = modifier.fillMaxWidth(),
                shape = AppShapes.button,
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = if (isPressed) IlicitanColors.Button.secondaryPressed else Color.Transparent,
                    contentColor = IlicitanColors.Button.default,
                    disabledContainerColor = IlicitanColors.Button.secondaryDisabled,
                    disabledContentColor = IlicitanColors.Button.contentDisabled
                ),
                border = if (enabled) BorderStroke(AppDimensions.primaryBorderWidth, IlicitanColors.Button.default) else null
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
private fun ActionButtonPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(AppSpacing.mediumLarge),
        modifier = Modifier
            .background(IlicitanColors.Surface.defaultPrimary)
            .padding(AppSpacing.medium)
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