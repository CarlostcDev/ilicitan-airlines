package com.carlostcdev.ilicitanairlines.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carlostcdev.ilicitanairlines.R
import com.carlostcdev.ilicitanairlines.ui.enums.StatusTextType
import com.carlostcdev.ilicitanairlines.ui.theme.AppDimensions
import com.carlostcdev.ilicitanairlines.ui.theme.AppShapes
import com.carlostcdev.ilicitanairlines.ui.theme.AppSpacing
import com.carlostcdev.ilicitanairlines.ui.theme.AppTypography
import com.carlostcdev.ilicitanairlines.ui.theme.IlicitanColors

@Composable
fun StatusText(
    text: String,
    status: StatusTextType,
    modifier: Modifier = Modifier
) {
    val color = when(status) {
        StatusTextType.SUCCESS -> IlicitanColors.Surface.borderSuccess
        StatusTextType.WARN -> IlicitanColors.Surface.borderWarn
        StatusTextType.ALERT -> IlicitanColors.Surface.borderAlert
    }

    Surface(
        color = IlicitanColors.Surface.default,
        shape = AppShapes.card,
        border = BorderStroke(AppDimensions.secondaryBorderWidth, color = color),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(horizontal = AppSpacing.smallMedium, vertical = AppSpacing.xSmall),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(AppSpacing.small)
        ) {
            Box(
                modifier = Modifier
                    .size(9.dp)
                    .background(color = color, shape = CircleShape)
            )
            Text(
                text = text,
                fontSize = AppTypography.labelSmall.fontSize
            )
        }
    }
}

@Preview
@Composable
fun StatusTextPreview() {
    Column(
        modifier = Modifier
            .background(IlicitanColors.Surface.default)
            .padding(AppSpacing.xSmall),
        verticalArrangement = Arrangement.spacedBy(AppSpacing.xSmall),
    ) {
        StatusText(
            text = stringResource(R.string.on_time),
            status = StatusTextType.SUCCESS
        )
        StatusText(
            text = stringResource(R.string.delayed),
            status = StatusTextType.WARN
        )
        StatusText(
            text = stringResource(R.string.canceled),
            status = StatusTextType.ALERT
        )
    }
}