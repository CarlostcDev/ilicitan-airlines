package com.carlostcdev.ilicitanairlines.ui.components

import androidx.compose.foundation.BorderStroke
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
import com.carlostcdev.ilicitanairlines.ui.enums.AppButtonType
import com.carlostcdev.ilicitanairlines.ui.theme.AppDimensions
import com.carlostcdev.ilicitanairlines.ui.theme.AppShapes
import com.carlostcdev.ilicitanairlines.ui.theme.AppSpacing
import com.carlostcdev.ilicitanairlines.ui.theme.AppTextSizes
import com.carlostcdev.ilicitanairlines.ui.theme.IlicitanAirlinesTheme
import com.carlostcdev.ilicitanairlines.ui.theme.Palette

@Composable
fun AppButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    buttonType: AppButtonType = AppButtonType.PRIMARY,
    buttonBackground: Color? = null,
    enabled: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    when (buttonType) {
        AppButtonType.PRIMARY ->
            Button(
                onClick = onClick,
                enabled = enabled,
                interactionSource = interactionSource,
                modifier = modifier.fillMaxWidth(),
                shape = AppShapes.b5,
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonBackground ?: if (isPressed) Palette.secondary else Palette.primary,
                    contentColor = Palette.white,
                    disabledContainerColor = Palette.blackGray,
                    disabledContentColor = Palette.white
                )
            ) {
                Text(
                    text = label,
                    fontSize = AppTextSizes.t18,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(AppSpacing.p8)
                )
            }

        AppButtonType.SECONDARY ->
            OutlinedButton(
                onClick = onClick,
                enabled = enabled,
                interactionSource = interactionSource,
                modifier = modifier.fillMaxWidth(),
                shape = AppShapes.b5,
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = buttonBackground ?: if (isPressed) Palette.silverGray else Palette.transparent,
                    contentColor = Palette.primary,
                    disabledContainerColor = Palette.gray,
                    disabledContentColor = Palette.white
                ),
                border = if (enabled) BorderStroke(AppDimensions.primaryBorderWidth, Palette.primary) else null
            ) {
                Text(
                    text = label,
                    fontSize = AppTextSizes.t18,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(AppSpacing.p8)
                )
            }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppButtonPreview() {
    IlicitanAirlinesTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(AppSpacing.p20),
            modifier = Modifier.padding(AppSpacing.p16)
        ) {
            AppButton(
                label = "Primary Enabled",
                onClick = {},
                buttonType = AppButtonType.PRIMARY
            )
            AppButton(
                label = "Primary Disabled",
                onClick = {},
                enabled = false,
                buttonType = AppButtonType.PRIMARY
            )
            AppButton(
                label = "Secondary Enabled",
                onClick = {},
                buttonType = AppButtonType.SECONDARY
            )
            AppButton(
                label = "Secondary Disabled",
                onClick = {},
                enabled = false,
                buttonType = AppButtonType.SECONDARY
            )
        }
    }
}