package com.carlostcdev.ilicitanairlines.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carlostcdev.ilicitanairlines.R
import com.carlostcdev.ilicitanairlines.ui.enums.StatusTextType
import com.carlostcdev.ilicitanairlines.ui.theme.AppSpacing
import com.carlostcdev.ilicitanairlines.ui.theme.AppTextSizes
import com.carlostcdev.ilicitanairlines.ui.theme.IlicitanAirlinesTheme
import com.carlostcdev.ilicitanairlines.ui.theme.IlicitanColors

@Composable
fun FlightCard(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Row(
            modifier = Modifier
                .background(IlicitanColors.Surface.defaultPrimary)
                .height(IntrinsicSize.Min)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(AppSpacing.small)
                    .weight(3f)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    StatusText(
                        "En hora",
                        StatusTextType.SUCCESS
                    )
                    IataFlight(
                        "789"
                    )
                }
                FlightRouteTimeline(
                    originCode = "MAD",
                    originCity = "Madrid",
                    destinationCode = "HND",
                    destinationCity = "Tokyo",
                    duration = "13h 25m"
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(IlicitanColors.Surface.defaultSecondary)
                    .drawBehind {
                        drawLine(
                            color = IlicitanColors.Text.defaultPrimary,
                            start = Offset(2.dp.toPx(), 0f),
                            end = Offset(2.dp.toPx(), size.height),
                            strokeWidth = 4.dp.toPx(),
                            cap = StrokeCap.Butt,
                            pathEffect = PathEffect.dashPathEffect(
                                floatArrayOf(10.dp.toPx(), 6.dp.toPx())
                            )
                        )
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_flight_ticket),
                    contentDescription = null,
                    tint = IlicitanColors.Icon.defaultSecondary
                )
                Text(
                    text = "ECONOMY",
                    fontSize = AppTextSizes.large,
                    fontWeight = FontWeight.Bold,
                    color = IlicitanColors.Text.defaultSecondary
                )
                Text(
                    text = "859,90€",
                    fontSize = AppTextSizes.large,
                    fontWeight = FontWeight.Bold,
                    color = IlicitanColors.Text.defaultSecondary
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FlightCardPreview() {
    IlicitanAirlinesTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(AppSpacing.medium),
            modifier = Modifier.padding(AppSpacing.medium)
        ) {
            FlightCard(
                onClick = { }
            )
            FlightCard(
                onClick = { }
            )
            FlightCard(
                onClick = { }
            )
        }
    }

}