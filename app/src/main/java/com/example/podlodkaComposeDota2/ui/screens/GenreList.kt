package com.example.podlodkaComposeDota2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.podlodkaComposeDota2.ui.theme.PodlodkaComposeTheme
import com.example.podlodkaComposeDota2.ui.theme.labelColor
import com.example.podlodkaComposeDota2.ui.theme.labelTextColor

@Composable
fun GenreListRender(genreList: List<String>) {
    Row(
        modifier = Modifier
            .padding(top = 24.dp, start = 24.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        genreList.forEach {
            Label(text = it)
        }
    }
}

@Composable
fun Label(text: String) {
    Text(
        modifier = Modifier
            .padding(end = 10.dp)
            .background(labelColor, RoundedCornerShape(100.dp))
            .padding(horizontal = 10.dp, vertical = 5.dp),
        text = text,
        fontSize = 10.sp,
        fontWeight = FontWeight.W500,
        color = labelTextColor
    )
}