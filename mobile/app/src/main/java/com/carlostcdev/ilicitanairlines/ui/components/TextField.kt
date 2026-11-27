package com.carlostcdev.ilicitanairlines.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.carlostcdev.ilicitanairlines.R
import com.carlostcdev.ilicitanairlines.ui.theme.AppDimensions
import com.carlostcdev.ilicitanairlines.ui.theme.AppShapes
import com.carlostcdev.ilicitanairlines.ui.theme.AppSpacing
import com.carlostcdev.ilicitanairlines.ui.theme.IlicitanAirlinesTheme
import com.carlostcdev.ilicitanairlines.ui.theme.Palette

@Composable
fun TextField(
    title: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    errorMsg: String = "",
    icon: Int? = null,
    writable: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()
    val showBorder = isFocused || value.isNotBlank() || errorMsg.isNotBlank()

    val titleColor = when {
        errorMsg.isNotBlank() -> Palette.error
        value.isNotBlank() -> Palette.primary
        else -> Palette.black
    }

    val iconColor = when {
        errorMsg.isNotBlank() -> Palette.error
        isFocused || value.isNotBlank() -> Palette.primary
        else -> Palette.blackGray
    }

    val borderColor = when {
        errorMsg.isNotBlank() -> Palette.error
        isFocused || value.isNotBlank() -> Palette.primary
        else -> Color.Transparent
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(AppSpacing.xSmall)
    ) {
        Text(
            text = title,
            color = titleColor
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .then(
                    if (showBorder) Modifier.border(AppDimensions.primaryBorderWidth, borderColor, AppShapes.input)
                    else Modifier
                )
        ) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier.fillMaxWidth(),
                interactionSource = interactionSource,
                placeholder = { Text(placeholder) },
                trailingIcon = if (icon != null) { {
                    Icon(
                        painter = painterResource(icon),
                        contentDescription = title,
                        tint = iconColor,
                        modifier = Modifier.size(AppDimensions.iconSize)
                    )
                } } else null,
                readOnly = !writable,
                singleLine = true,
                isError = errorMsg.isNotBlank(),
                shape = AppShapes.input,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Palette.lightGray,
                    unfocusedContainerColor = Palette.lightGray,
                    disabledContainerColor = Palette.lightGray,
                    errorContainerColor = Palette.lightGray,
                    focusedTextColor = Palette.black,
                    unfocusedTextColor = Palette.black,
                    errorTextColor = Palette.black,
                    focusedPlaceholderColor = Palette.darkGray,
                    unfocusedPlaceholderColor = Palette.darkGray,
                    errorPlaceholderColor = Palette.darkGray,
                    focusedBorderColor = Palette.transparent,
                    unfocusedBorderColor = Palette.transparent,
                    disabledBorderColor = Palette.transparent,
                    errorBorderColor = Palette.transparent,
                    cursorColor = Palette.primary,
                    errorCursorColor = Palette.error
                )
            )
        }

        if (errorMsg.isNotBlank()) {
            Text(
                text = errorMsg,
                color = Palette.error,
                modifier = Modifier.padding(top = AppSpacing.xSmall)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TextFieldPreview() {
    IlicitanAirlinesTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(AppSpacing.mediumLarge),
            modifier = Modifier.padding(AppSpacing.medium)
        ) {
            TextField(
                title = "Origen",
                value = "",
                onValueChange = {},
                placeholder = "Ej: MAD",
                icon = R.drawable.ic_flight_takeoff
            )

            TextField(
                title = "Origen",
                value = "HND",
                onValueChange = {},
                placeholder = "Ej: MAD",
                icon = R.drawable.ic_flight_takeoff
            )

            TextField(
                title = "Origen",
                value = "HND",
                onValueChange = {},
                placeholder = "Ej: MAD",
                errorMsg = "Indica un origen válido",
                icon = R.drawable.ic_flight_takeoff
            )
        }
    }
}