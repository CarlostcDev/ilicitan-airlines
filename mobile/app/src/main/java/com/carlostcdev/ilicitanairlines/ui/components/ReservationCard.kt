package com.carlostcdev.ilicitanairlines.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.carlostcdev.ilicitanairlines.R
import com.carlostcdev.ilicitanairlines.ui.theme.AppDimensions
import com.carlostcdev.ilicitanairlines.ui.theme.AppShapes
import com.carlostcdev.ilicitanairlines.ui.theme.AppSpacing
import com.carlostcdev.ilicitanairlines.ui.theme.AppTextSizes
import com.carlostcdev.ilicitanairlines.ui.theme.IlicitanAirlinesTheme
import com.carlostcdev.ilicitanairlines.ui.theme.Palette

@Composable
fun ReservationCard(
    url: String,
    city: String,
    departureDate: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(240.dp),
        shape = AppShapes.b20,
        shadowElevation = AppDimensions.shadow,
        color = Palette.black
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = url,
                contentDescription = stringResource(R.string.reservation_flight_description, city, departureDate),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Palette.transparentBlack)
            )
            Column(
                modifier = Modifier.padding(AppSpacing.p12)
            ) {
                Text(
                    text = stringResource(R.string.reservation_flight, city),
                    fontSize = AppTextSizes.t32,
                    fontWeight = FontWeight.SemiBold,
                    color = Palette.white
                )
                Text(
                    text = departureDate,
                    fontSize = AppTextSizes.t24,
                    color = Palette.white
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ReservationCardPreview() {
    IlicitanAirlinesTheme {
        ReservationCard(
            url = "https://assets.ilicitan-airlines.com/backgrounds/HND-background.webp",
            city = "Tokyo",
            departureDate = "Oct 15, 2027",
            modifier = Modifier.padding(AppSpacing.p20)
        )
    }
}