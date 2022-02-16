package com.example.podlodkaComposeDota2.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.podlodkaComposeDota2.R
import com.example.podlodkaComposeDota2.ui.theme.PodlodkaComposeTheme
import com.example.podlodkaComposeDota2.ui.theme.background

@Composable
fun VideoBlock(videoList: List<Int>) {
    Row(
        modifier = Modifier
            .padding(top = 24.dp, start = 24.dp)
            .height(135.dp)
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
    ) {
        videoList.forEach {
            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(end = 16.dp)
                    .background(background, RoundedCornerShape(14.dp)),
                painter = painterResource(id = it),
                contentDescription = "video",
                contentScale = ContentScale.FillHeight
            )
        }
    }
}

@Preview
@Composable
fun VideoBlockRender() {
    MaterialTheme {
        VideoBlock(videoList = listOf(R.drawable.video_preview1, R.drawable.video_preview2))
    }
}