package com.carlostcdev.ilicitanairlines.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.carlostcdev.ilicitanairlines.R
import com.carlostcdev.ilicitanairlines.ui.enums.BaggageType
import com.carlostcdev.ilicitanairlines.ui.theme.AppSpacing
import com.carlostcdev.ilicitanairlines.ui.theme.AppTextSizes
import com.carlostcdev.ilicitanairlines.ui.theme.IlicitanAirlinesTheme

@Composable
fun InformationBaggage(
    name: String,
    type: BaggageType,
    weight: Double,
    height: Int,
    width: Int,
    length: Int,
    modifier: Modifier = Modifier
) {
    val icon = when(type) {
        BaggageType.PERSONAL_ITEM -> R.drawable.ic_personal_item
        BaggageType.CABIN -> R.drawable.ic_cabin_baggage
        BaggageType.CHECKED -> R.drawable.ic_checked_baggage
    }

    Row(
        modifier = modifier.height(IntrinsicSize.Min).fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(AppSpacing.p12),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxHeight()
        )
        Column {
            Text(
                text = name,
                fontSize = AppTextSizes.t20,
                fontWeight = FontWeight.Medium,
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = stringResource(R.string.baggage_dimensions_weight, height, width, length, weight),
                maxLines = 1,
                softWrap = false
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InformationBaggagePreview() {
    IlicitanAirlinesTheme {
        Column(
            modifier = Modifier.padding(AppSpacing.p12),
            verticalArrangement = Arrangement.spacedBy(AppSpacing.p12)
        ) {
            InformationBaggage(
                name = "Maleta de mano",
                type = BaggageType.PERSONAL_ITEM,
                weight = 7.0,
                height = 40,
                width = 30,
                length = 20
            )
            InformationBaggage(
                name = "Maleta de cabina",
                type = BaggageType.CABIN,
                weight = 14.0,
                height = 56,
                width = 25,
                length = 20
            )
            InformationBaggage(
                name = "Maleta facturada",
                type = BaggageType.CHECKED,
                weight = 23.0,
                height = 70,
                width = 40,
                length = 30
            )
        }
    }
}