package com.carlostcdev.ilicitanairlines.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carlostcdev.ilicitanairlines.R
import com.carlostcdev.ilicitanairlines.ui.enums.StatusTextType
import com.carlostcdev.ilicitanairlines.ui.theme.AppSpacing
import com.carlostcdev.ilicitanairlines.ui.theme.AppTextSizes
import com.carlostcdev.ilicitanairlines.ui.theme.IlicitanColors

@Composable
fun FlightCard(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Card(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .background(IlicitanColors.Surface.defaultPrimary)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(AppSpacing.small)
            ) {
                Row(

                ) {
                    StatusText(
                        "En hora",
                        StatusTextType.SUCCESS
                    )

                }
            }
            Column(
                modifier = Modifier.background(IlicitanColors.Surface.defaultSecondary),
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
                ActionButton(
                    label = "Seleccionar",
                    onClick = onClick,
                    enabled = enabled,
                    modifier = Modifier.background(IlicitanColors.Button.primaryPressed)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FlightCardPreview() {
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