package com.carlostcdev.ilicitanairlines

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.carlostcdev.ilicitanairlines.ui.components.FlightCard
import com.carlostcdev.ilicitanairlines.ui.enums.StatusTextType
import com.carlostcdev.ilicitanairlines.ui.theme.AppTextSizes
import com.carlostcdev.ilicitanairlines.ui.theme.IlicitanAirlinesTheme
import com.carlostcdev.ilicitanairlines.ui.theme.IlicitanColors

@Composable
fun IlicitanAirlinesApp() {
    IlicitanAirlinesTheme {
        Scaffold(
            containerColor = Color.White,
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                Text(
                    text = stringResource(R.string.coming_soon),
                    color = IlicitanColors.Text.defaultPrimary,
                    fontSize = AppTextSizes.xxLarge
                )
                FlightCard(
                    statusText = "En hora",
                    statusType = StatusTextType.SUCCESS,
                    iataCode = "IL789",
                    originCode = "MAD",
                    originCity = "Madrid",
                    destinationCode = "HND",
                    destinationCity = "Tokyo",
                    duration = "13h 25m",
                    cabinClass = "ECONOMY PREMIUM",
                    departureDate = "Oct 10, 2027",
                    departureTime = "12:45",
                    arrivalDate = "Oct 11, 2027",
                    arrivalTime = "09:10",
                    price = "859,90€",
                    onClick = {}
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun IlicitanAirlinesAppPreview() = IlicitanAirlinesApp()