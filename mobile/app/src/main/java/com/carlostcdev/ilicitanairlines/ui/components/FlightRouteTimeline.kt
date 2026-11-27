package com.carlostcdev.ilicitanairlines.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carlostcdev.ilicitanairlines.R
import com.carlostcdev.ilicitanairlines.ui.theme.AppDimensions
import com.carlostcdev.ilicitanairlines.ui.theme.AppSpacing
import com.carlostcdev.ilicitanairlines.ui.theme.AppTextSizes
import com.carlostcdev.ilicitanairlines.ui.theme.IlicitanAirlinesTheme
import com.carlostcdev.ilicitanairlines.ui.theme.Palette
import java.util.Locale

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
                text = originCode.trim().uppercase(Locale.ROOT),
                fontSize = AppTextSizes.t32,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = originCity,
                fontSize = AppTextSizes.t18,
                fontWeight = FontWeight.Medium
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 5.dp)
                .fillMaxWidth(),
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
                        .padding(horizontal = AppSpacing.p4)
                        .rotate(90f)
                        .size(AppDimensions.largeIconSize),
                    tint = Palette.dark
                )
                DashedLine(modifier = Modifier.weight(1f))
            }
            Text(
                text = duration,
                fontSize = AppTextSizes.t12
            )
        }
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = destinationCode.trim().uppercase(Locale.ROOT),
                fontSize = AppTextSizes.t32,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = destinationCity,
                fontSize = AppTextSizes.t18,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
private fun DashedLine(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.height(1.dp)) {
        drawLine(
            color = Palette.black,
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
    IlicitanAirlinesTheme {
        FlightRouteTimeline(
            originCode = "HND",
            originCity = "Tokyo",
            destinationCode = "MAD",
            destinationCity = "Madrid",
            duration = stringResource(R.string.flight_time, 13, 25),
            modifier = Modifier.padding(AppSpacing.p8)
        )
    }

}