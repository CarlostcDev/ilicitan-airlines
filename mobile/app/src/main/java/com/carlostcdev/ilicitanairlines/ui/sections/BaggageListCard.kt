package com.carlostcdev.ilicitanairlines.ui.sections

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.carlostcdev.ilicitanairlines.R
import com.carlostcdev.ilicitanairlines.model.Baggage
import com.carlostcdev.ilicitanairlines.ui.components.InformationBaggage
import com.carlostcdev.ilicitanairlines.ui.enums.BaggageType
import com.carlostcdev.ilicitanairlines.ui.theme.AppDimensions
import com.carlostcdev.ilicitanairlines.ui.theme.AppShapes
import com.carlostcdev.ilicitanairlines.ui.theme.AppSpacing
import com.carlostcdev.ilicitanairlines.ui.theme.AppTextSizes
import com.carlostcdev.ilicitanairlines.ui.theme.IlicitanAirlinesTheme
import com.carlostcdev.ilicitanairlines.ui.theme.Palette
import java.util.Locale

@Composable
fun BaggageListCard(
    @DrawableRes icon: Int,
    originIataCode: String,
    destinationIataCode: String,
    description: String,
    baggages: List<Baggage>,
    selectedBaggageIds: Set<Long>,
    onBaggageToggle: (Baggage, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = AppShapes.b20,
        colors = CardDefaults.cardColors(containerColor = Palette.white),
        elevation = CardDefaults.cardElevation(defaultElevation = AppDimensions.shadow)
    ) {
        Column(
            modifier = Modifier.padding(AppSpacing.p16),
            verticalArrangement = Arrangement.spacedBy(AppSpacing.p16)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Palette.lightGray, AppShapes.b15)
                    .padding(horizontal = AppSpacing.p16, vertical = AppSpacing.p12),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(AppSpacing.p12)
            ) {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = null,
                    modifier = Modifier.size(AppDimensions.ic24)
                )
                Text(
                    text = stringResource(
                        R.string.section_title,
                        originIataCode.uppercase(Locale.ROOT),
                        destinationIataCode.uppercase(Locale.ROOT)
                    ),
                    fontSize = AppTextSizes.t20,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = description,
                fontSize = AppTextSizes.t18
            )

            baggages.forEach { baggage ->
                val isIncluded = baggage.included || baggage.price == 0.0
                val isChecked = isIncluded || baggage.id in selectedBaggageIds
                val isEnabled = !isIncluded

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(AppShapes.b10)
                        .toggleable(
                            value = isChecked,
                            enabled = isEnabled,
                            role = Role.Checkbox,
                            onValueChange = { checked -> onBaggageToggle(baggage, checked) }
                        )
                        .padding(vertical = AppSpacing.p4),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(AppSpacing.p12)
                ) {
                    InformationBaggage(
                        name = baggage.name,
                        type = baggage.type,
                        weight = baggage.weight,
                        height = baggage.height,
                        width = baggage.width,
                        length = baggage.length,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = if (isIncluded) stringResource(R.string.free) else stringResource(R.string.price_added, baggage.price),
                        fontSize = AppTextSizes.t18
                    )
                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = null,
                        enabled = isEnabled,
                        colors = CheckboxDefaults.colors(
                            checkedColor = Palette.primary,
                            uncheckedColor = Palette.black,
                            checkmarkColor = Palette.white,
                            disabledCheckedColor = Palette.darkGray,
                            disabledUncheckedColor = Palette.silverGray
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_9_PRO_XL)
@Composable
private fun BaggageListCardPreview() {
    IlicitanAirlinesTheme {
        val baggages = listOf(
            Baggage(
                id = 1L,
                name = "Maleta de mano",
                type = BaggageType.PERSONAL_ITEM,
                weight = 7.0,
                height = 40,
                width = 30,
                length = 15,
                price = 0.0,
                included = true
            ),
            Baggage(
                id = 2L,
                name = "Maleta de cabina",
                type = BaggageType.CABIN,
                weight = 14.0,
                height = 56,
                width = 25,
                length = 20,
                price = 24.99
            ),
            Baggage(
                id = 3L,
                name = "Maleta facturada",
                type = BaggageType.CHECKED,
                weight = 23.0,
                height = 70,
                width = 40,
                length = 30,
                price = 34.99
            )
        )

        BaggageListCard(
            icon = R.drawable.ic_flight_takeoff,
            originIataCode = "MAD",
            destinationIataCode = "HND",
            description = "El vuelo incluye la maleta, puedes elegir más equipaje disponible.",
            baggages = baggages,
            selectedBaggageIds = emptySet(),
            onBaggageToggle = { _, _ -> },
            modifier = Modifier.padding(AppSpacing.p16)
        )
    }
}