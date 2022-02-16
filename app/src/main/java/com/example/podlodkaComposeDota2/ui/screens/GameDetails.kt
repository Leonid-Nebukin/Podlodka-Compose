package com.example.podlodkaComposeDota2.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.podlodkaComposeDota2.data.model.GameDetailsData
import com.example.podlodkaComposeDota2.ui.theme.descriptionTextColor

@Composable
fun GameDetailsRender(gameDetailsData: GameDetailsData) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 144.dp)
    ) {
        PosterWithLogo(posterWithInformationData = gameDetailsData.posterWithInformation)
        GenreListRender(gameDetailsData.genreList)

        //description
        Text(
            modifier = Modifier.padding(top = 24.dp, start = 24.dp, end = 24.dp),
            text = gameDetailsData.description,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = descriptionTextColor
        )

        VideoBlock(gameDetailsData.videoList)
        ReviewBlock(gameDetailsData.reviewData)
    }
}

@Preview(device = Devices.PIXEL_4_XL)
@Composable
fun MainScreenRender() {
    MaterialTheme {
        GameDetailsRender(GameDetailsData.createExample())
    }
}