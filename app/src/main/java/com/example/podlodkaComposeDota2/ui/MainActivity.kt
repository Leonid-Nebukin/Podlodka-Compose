package com.example.podlodkaComposeDota2.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.podlodkaComposeDota2.data.model.GameDetailsData
import com.example.podlodkaComposeDota2.ui.screens.GameDetailsRender
import com.example.podlodkaComposeDota2.ui.theme.PodlodkaComposeTheme
import com.example.podlodkaComposeDota2.ui.theme.background
import com.example.podlodkaComposeDota2.ui.theme.buttonColor
import com.google.accompanist.insets.ProvideWindowInsets


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ProvideWindowInsets(windowInsetsAnimationsEnabled = true) {
                PodlodkaComposeTheme {
                    Scaffold(
                        floatingActionButtonPosition = FabPosition.Center,
                        floatingActionButton = {
                            ExtendedFloatingActionButton(
                                modifier = Modifier
                                    .padding(start = 24.dp, end = 24.dp, bottom = 40.dp)
                                    .fillMaxWidth()
                                    .height(64.dp),
                                text = {
                                    Text(
                                        text = "Install",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.W700,
                                        color = background
                                    )
                                },
                                backgroundColor = buttonColor,
                                onClick = { },
                                shape = RoundedCornerShape(12.dp)
                            )
                        }
                    ) {
                        GameDetailsRender(GameDetailsData.createExample())
                    }
                }
            }
        }
    }
}
