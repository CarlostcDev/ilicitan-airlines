package com.carlostcdev.ilicitanairlines

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.carlostcdev.ilicitanairlines.ui.theme.IlicitanAirlinesTheme

@Composable
fun IlicitanAirlinesApp() {
    IlicitanAirlinesTheme {
        Scaffold(
            containerColor = Color.Black,
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Text(
                text = "🚀 Coming soon...",
                color = Color.White,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun IlicitanAirlinesAppPreview() {
    IlicitanAirlinesApp()
}