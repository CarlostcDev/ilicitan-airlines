package com.carlostcdev.ilicitanairlines.ui.components

import android.util.Log
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.carlostcdev.ilicitanairlines.ui.theme.AppShapes
import com.carlostcdev.ilicitanairlines.ui.theme.IlicitanAirlinesTheme

@Composable
fun ReservationCard(
    city: String,
    departureDate: String
) {
    AsyncImage(
        model = "https://assets.ilicitan-airlines.com/backgrounds/ALC-background.webp",
        contentDescription = "Reserva de vuelo a $city",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(120.dp)
            .clip(AppShapes.b20),
        onError = {
            Log.e("ReservationCard", "Error cargando imagen", it.result.throwable)
        },
        onSuccess = {
            Log.d("ReservationCard", "Imagen cargada correctamente")
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ReservationCardPreview() {
    IlicitanAirlinesTheme {
        ReservationCard("", "")
    }
}