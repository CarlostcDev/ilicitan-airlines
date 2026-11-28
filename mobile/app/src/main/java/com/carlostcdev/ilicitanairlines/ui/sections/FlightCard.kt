package com.carlostcdev.ilicitanairlines.ui.sections

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carlostcdev.ilicitanairlines.R
import com.carlostcdev.ilicitanairlines.ui.components.FlightRouteTimeline
import com.carlostcdev.ilicitanairlines.ui.components.IataFlight
import com.carlostcdev.ilicitanairlines.ui.components.StatusText
import com.carlostcdev.ilicitanairlines.ui.enums.StatusTextType
import com.carlostcdev.ilicitanairlines.ui.theme.AppSpacing
import com.carlostcdev.ilicitanairlines.ui.theme.AppTextSizes
import com.carlostcdev.ilicitanairlines.ui.theme.IlicitanAirlinesTheme
import com.carlostcdev.ilicitanairlines.ui.theme.Palette

@Composable
fun FlightCard(
    statusText: String,
    statusType: StatusTextType,
    iataCode: String,
    originCode: String,
    originCity: String,
    destinationCode: String,
    destinationCity: String,
    duration: String,
    cabinClass: String,
    departureDate: String,
    departureTime: String,
    arrivalDate: String,
    arrivalTime: String,
    price: String,
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
                .background(Palette.white)
                .height(IntrinsicSize.Min)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier
                    .padding(AppSpacing.p12)
                    .weight(3f)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    StatusText(
                        text = statusText,
                        status = statusType
                    )
                    IataFlight(
                        iataCode = iataCode
                    )
                }
                FlightRouteTimeline(
                    originCode = originCode,
                    originCity = originCity,
                    destinationCode = destinationCode,
                    destinationCity = destinationCity,
                    duration = duration
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = departureDate,
                            fontSize = AppTextSizes.t12
                        )
                        Text(
                            text = departureTime,
                            fontSize = AppTextSizes.t12
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = arrivalDate,
                            fontSize = AppTextSizes.t12
                        )
                        Text(
                            text = arrivalTime,
                            fontSize = AppTextSizes.t12
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .weight(1.1f)
                    .fillMaxHeight()
                    .background(Palette.primary)
                    .drawBehind {
                        drawLine(
                            color = Palette.black,
                            start = Offset(2.dp.toPx(), 0f),
                            end = Offset(2.dp.toPx(), size.height),
                            strokeWidth = 3.dp.toPx(),
                            cap = StrokeCap.Butt,
                            pathEffect = PathEffect.dashPathEffect(floatArrayOf(6.dp.toPx(), 5.dp.toPx()))
                        )
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_flight_ticket),
                    contentDescription = null,
                    tint = Palette.white,
                    modifier = Modifier.padding(top = 20.dp)
                )
                Text(
                    text = cabinClass.trim().replace(" ", "\n"),
                    fontSize = AppTextSizes.t18,
                    fontWeight = FontWeight.Bold,
                    color = Palette.white,
                    textAlign = TextAlign.Center,
                    softWrap = false
                )
                Text(
                    text = price.trim(),
                    fontSize = AppTextSizes.t20,
                    fontWeight = FontWeight.Bold,
                    color = Palette.white,
                    modifier = Modifier.padding(bottom = 10.dp),
                    maxLines = 1,
                    softWrap = false
                )
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_9_PRO_XL)
@Composable
private fun FlightCardPreview() {
    IlicitanAirlinesTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(AppSpacing.p16),
            modifier = Modifier.padding(AppSpacing.p16)
        ) {
            FlightCard(
                statusText = "En hora",
                statusType = StatusTextType.SUCCESS,
                iataCode = "IL789",
                originCode = "MAD",
                originCity = "Madrid",
                destinationCode = "HND",
                destinationCity = "Tokyo",
                duration = stringResource(R.string.flight_time, 13, 25),
                cabinClass = stringResource(R.string.economy_premium_class),
                departureDate = "Oct 10, 2027",
                departureTime = "12:45",
                arrivalDate = "Oct 11, 2027",
                arrivalTime = "09:10",
                price = stringResource(R.string.price, 859.99),
                onClick = {}
            )
            FlightCard(
                statusText = "Retrasado",
                statusType = StatusTextType.WARN,
                iataCode = "IL412",
                originCode = "ALC",
                originCity = "Alicante",
                destinationCode = "NRT",
                destinationCity = "Tokyo",
                duration = stringResource(R.string.flight_time, 14, 10),
                cabinClass = stringResource(R.string.business_class),
                departureDate = "Nov 15, 2027",
                departureTime = "08:30",
                arrivalDate = "Nov 15, 2027",
                arrivalTime = "22:40",
                price = stringResource(R.string.price, 1400.20),
                onClick = {}
            )
            FlightCard(
                statusText = "Cancelado",
                statusType = StatusTextType.ALERT,
                iataCode = "IL105",
                originCode = "BCN",
                originCity = "Barcelona",
                destinationCode = "ICN",
                destinationCity = "Seoul",
                duration = stringResource(R.string.flight_time, 12, 10),
                cabinClass = stringResource(R.string.economy_class),
                departureDate = "Dec 22, 2027",
                departureTime = "17:20",
                arrivalDate = "Dec 23, 2027",
                arrivalTime = "14:10",
                price = stringResource(R.string.price, 689.50),
                onClick = {}
            )
        }
    }
}