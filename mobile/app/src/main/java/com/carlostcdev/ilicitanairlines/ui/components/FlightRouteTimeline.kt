package com.carlostcdev.ilicitanairlines.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carlostcdev.ilicitanairlines.R
import com.carlostcdev.ilicitanairlines.ui.theme.AppDimensions
import com.carlostcdev.ilicitanairlines.ui.theme.AppShapes
import com.carlostcdev.ilicitanairlines.ui.theme.AppSpacing
import com.carlostcdev.ilicitanairlines.ui.theme.AppTextSizes
import com.carlostcdev.ilicitanairlines.ui.theme.IlicitanColors

@Composable
fun FlightRouteTimeline(
    originCode: String,
    originCity: String,
    destinationCode: String,
    destinationCity: String,
    duration: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
    ) {
        Column {
            Text(
                text = originCode,
                fontSize = AppTextSizes.xxxLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = originCity,
                fontSize = AppTextSizes.large
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                DashedLine(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(R.drawable.ic_aircraft),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(horizontal = AppSpacing.xSmall)
                        .rotate(90f)
                        .size(AppDimensions.largeIconSize),
                    tint = IlicitanColors.Icon.defaultPrimary
                )
                DashedLine(modifier = Modifier.weight(1f))
            }
            Text(
                text = duration,
                fontSize = AppTextSizes.xSmall
            )
        }
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = destinationCode,
                fontSize = AppTextSizes.xxxLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = destinationCity,
                fontSize = AppTextSizes.large
            )
        }
    }
}

@Composable
private fun DashedLine(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.height(1.dp)) {
        drawLine(
            color = IlicitanColors.Text.defaultPrimary,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            strokeWidth = AppDimensions.primaryBorderWidth.toPx(),
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 8f), 0f)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FlightRouteTimelinePreview() {
    FlightRouteTimeline(
        originCode = "HND",
        originCity = "Tokyo",
        destinationCode = "MAD",
        destinationCity = "Madrid",
        duration = "12h 25m",
        modifier = Modifier.padding(AppSpacing.small)
    )
}