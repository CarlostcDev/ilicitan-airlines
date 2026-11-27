package com.carlostcdev.ilicitanairlines.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carlostcdev.ilicitanairlines.R
import com.carlostcdev.ilicitanairlines.ui.enums.ActionButtonType
import com.carlostcdev.ilicitanairlines.ui.theme.AppDimensions
import com.carlostcdev.ilicitanairlines.ui.theme.AppShapes
import com.carlostcdev.ilicitanairlines.ui.theme.AppSpacing
import com.carlostcdev.ilicitanairlines.ui.theme.AppTextSizes
import com.carlostcdev.ilicitanairlines.ui.theme.IlicitanAirlinesTheme
import com.carlostcdev.ilicitanairlines.ui.theme.Palette

@Composable
fun ActionButton(
    text: String,
    @DrawableRes icon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    actionButtonType: ActionButtonType = ActionButtonType.PRIMARY,
    enabled: Boolean = true
) {
    val buttonColors = when (actionButtonType) {
        ActionButtonType.PRIMARY -> ButtonDefaults.buttonColors(
            containerColor = Palette.lightGray,
            contentColor = Palette.black,
            disabledContainerColor = Palette.silverGray,
            disabledContentColor = Palette.darkGray
        )
        ActionButtonType.SECONDARY -> ButtonDefaults.buttonColors(
            containerColor = Palette.primary,
            contentColor = Palette.white,
            disabledContainerColor = Palette.transparentGreen,
            disabledContentColor = Palette.white
        )
        ActionButtonType.TERTIARY -> ButtonDefaults.buttonColors(
            containerColor = Palette.black,
            contentColor = Palette.white,
            disabledContainerColor = Palette.transparentBlack,
            disabledContentColor = Palette.white
        )
    }

    CompositionLocalProvider(LocalMinimumInteractiveComponentSize provides 0.dp) {
        Button(
            onClick = onClick,
            enabled = enabled,
            modifier = modifier,
            shape = AppShapes.b15,
            colors = buttonColors,
            contentPadding = PaddingValues(AppSpacing.p10)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(AppSpacing.p20),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = null,
                    modifier = Modifier.size(AppDimensions.ic28)
                )
                Text(
                    text = text,
                    fontSize = AppTextSizes.t18,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ActionButtonPreview() {
    IlicitanAirlinesTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(AppSpacing.p12),
            modifier = Modifier.padding(AppSpacing.p12)
        ) {
            ActionButton(
                text = "Realizar check-in",
                icon = R.drawable.ic_edit,
                actionButtonType = ActionButtonType.PRIMARY,
                onClick = {}
            )
            ActionButton(
                text = "Realizar check-in",
                icon = R.drawable.ic_edit,
                actionButtonType = ActionButtonType.SECONDARY,
                onClick = {}
            )
            ActionButton(
                text = "Realizar check-in",
                icon = R.drawable.ic_edit,
                actionButtonType = ActionButtonType.TERTIARY,
                onClick = {}
            )
            ActionButton(
                text = "Realizar check-in",
                icon = R.drawable.ic_edit,
                actionButtonType = ActionButtonType.PRIMARY,
                enabled = false,
                onClick = {}
            )
            ActionButton(
                text = "Realizar check-in",
                icon = R.drawable.ic_edit,
                actionButtonType = ActionButtonType.SECONDARY,
                enabled = false,
                onClick = {}
            )
            ActionButton(
                text = "Realizar check-in",
                icon = R.drawable.ic_edit,
                actionButtonType = ActionButtonType.TERTIARY,
                enabled = false,
                onClick = {}
            )
        }
    }
}