package com.carlostcdev.ilicitanairlines.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carlostcdev.ilicitanairlines.R
import com.carlostcdev.ilicitanairlines.ui.theme.AppTextSizes
import com.carlostcdev.ilicitanairlines.ui.theme.IlicitanAirlinesTheme

@Composable
fun IataFlight(
    iataCode: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        Image(
            painter = painterResource(R.drawable.ic_ilicitan_airlines),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = "IL$iataCode",
            fontWeight = FontWeight.Bold,
            fontSize = AppTextSizes.large
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun IataFlightPreview() {
    IlicitanAirlinesTheme {
        IataFlight(
            "849",
            Modifier.padding(5.dp)
        )
    }
}