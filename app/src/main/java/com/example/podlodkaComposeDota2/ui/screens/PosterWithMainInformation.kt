package com.example.podlodkaComposeDota2.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.podlodkaComposeDota2.R
import com.example.podlodkaComposeDota2.data.model.PosterWithInformationData
import com.example.podlodkaComposeDota2.ui.theme.PodlodkaComposeTheme
import com.example.podlodkaComposeDota2.ui.theme.backButtonBorder
import com.example.podlodkaComposeDota2.ui.theme.borderColor
import com.example.podlodkaComposeDota2.ui.theme.countFeedback
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle

@Composable
fun PosterWithLogo(posterWithInformationData: PosterWithInformationData) {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth(),
        constraintSet = ConstraintSet {
            val poster = createRefFor("poster")
            val titleGame = createRefFor("title")
            val logoBox = createRefFor("logoBox")
            val rating = createRefFor("rating")
            val countFeedback = createRefFor("countFeedback")
            val backButton = createRefFor("backButton")
            val moreButton = createRefFor("moreButton")

            constrain(poster) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }

            constrain(titleGame) {
                top.linkTo(poster.bottom, 12.dp)
                start.linkTo(logoBox.end, 14.dp)
            }

            constrain(logoBox) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start, 26.dp)
            }

            constrain(rating) {
                top.linkTo(titleGame.bottom, 8.dp)
                start.linkTo(logoBox.end, 14.dp)
                bottom.linkTo(parent.bottom, 8.dp)
            }

            constrain(countFeedback) {
                start.linkTo(rating.end, 10.dp)
                bottom.linkTo(rating.bottom)
                top.linkTo(rating.top)
            }

            constrain(backButton) {
                start.linkTo(parent.start, 24.dp)
                top.linkTo(parent.top, 38.dp)
            }

            constrain(moreButton) {
                end.linkTo(parent.end, 24.dp)
                top.linkTo(parent.top, 38.dp)
            }
        }) {
        Image(
            modifier = Modifier
                .layoutId("poster")
                .fillMaxWidth(),
            painter = painterResource(id = posterWithInformationData.posterId),
            contentDescription = "poster",
            contentScale = ContentScale.FillWidth
        )

        Card(
            modifier = Modifier
                .layoutId("logoBox"),
            border = BorderStroke(2.dp, borderColor),
            backgroundColor = Color.Black,
            shape = RoundedCornerShape(12.dp)
        ) {
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .size(54.dp),
                painter = painterResource(id = posterWithInformationData.gameLogo),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }

        Text(
            modifier = Modifier.layoutId("title"),
            text = posterWithInformationData.nameGame,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.5.sp,
            color = Color.White
        )

        RatingBar(
            modifier = Modifier.layoutId("rating"),
            value = posterWithInformationData.ratingGame,
            config = RatingBarConfig()
                .style(RatingBarStyle.Normal)
                .size(12.dp)
                .padding(2.dp),
            onValueChange = {},
            onRatingChanged = {}
        )

        Text(
            modifier = Modifier.layoutId("countFeedback"),
            text = posterWithInformationData.countReview,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.5.sp,
            color = countFeedback
        )

        Box(
            Modifier
                .layoutId("backButton")
                .size(56.dp)
                .border(1.dp, backButtonBorder, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.ic_back_background),
                contentDescription = ""
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "back",
                tint = Color.White
            )
        }

        Box(
            Modifier
                .layoutId("moreButton")
                .size(56.dp)
                .border(1.dp, backButtonBorder, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.fillMaxSize()
                    .blur(6.dp),
                painter = painterResource(id = R.drawable.ic_more_background),
                contentDescription = ""
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_more),
                contentDescription = "more",
                tint = Color.White
            )
        }
    }
}