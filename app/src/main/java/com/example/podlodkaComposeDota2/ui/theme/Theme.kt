package com.example.podlodkaComposeDota2.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun PodlodkaComposeTheme(
    content: @Composable () -> Unit
) {
    val colors = darkColors(
        background = background
    )

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = Color.Transparent
    )

    MaterialTheme(
        colors = colors,
        content = content
    )
}