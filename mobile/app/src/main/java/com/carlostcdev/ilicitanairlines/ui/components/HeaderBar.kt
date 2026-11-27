package com.carlostcdev.ilicitanairlines.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.carlostcdev.ilicitanairlines.R
import com.carlostcdev.ilicitanairlines.ui.theme.AppDimensions
import com.carlostcdev.ilicitanairlines.ui.theme.AppShapes
import com.carlostcdev.ilicitanairlines.ui.theme.AppSpacing
import com.carlostcdev.ilicitanairlines.ui.theme.AppTextSizes
import com.carlostcdev.ilicitanairlines.ui.theme.IlicitanAirlinesTheme
import com.carlostcdev.ilicitanairlines.ui.theme.Palette

@Composable
fun HeaderBar(
    onBack: () -> Unit,
    title: String,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = AppSpacing.p8, end = AppSpacing.p8, top = AppSpacing.p28),
        shape = AppShapes.b20,
        color = Palette.white,
        shadowElevation = AppDimensions.shadow
    ) {
        TopAppBar(
            windowInsets = WindowInsets(0, 0, 0, 0),
            modifier = Modifier.fillMaxWidth(),
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Palette.transparent
            ),
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        text = title,
                        fontSize = AppTextSizes.t24,
                        fontWeight = FontWeight.Bold
                    )
                    if (icon != null) {
                        Icon(
                            painter = painterResource(icon),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(horizontal = AppSpacing.p20)
                                .size(AppDimensions.ic30)
                        )
                    }
                }
            },
            navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_back),
                        contentDescription = stringResource(R.string.back),
                        modifier = Modifier.size(AppDimensions.ic24)
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HeaderBarPreview() {
    IlicitanAirlinesTheme {
        HeaderBar(
            onBack = {},
            title = "Vuelo de ida",
            icon = R.drawable.ic_flight_takeoff
        )
    }
}