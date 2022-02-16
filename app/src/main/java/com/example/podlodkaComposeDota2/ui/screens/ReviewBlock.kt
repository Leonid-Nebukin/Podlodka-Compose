package com.example.podlodkaComposeDota2.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.podlodkaComposeDota2.data.model.ReviewData
import com.example.podlodkaComposeDota2.data.model.ReviewItem
import com.example.podlodkaComposeDota2.ui.theme.dateReviewColor
import com.example.podlodkaComposeDota2.ui.theme.dividerColor
import com.example.podlodkaComposeDota2.ui.theme.reviewTextColor
import com.example.podlodkaComposeDota2.ui.theme.reviewTitleColor
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle

@Composable
fun ReviewBlock(reviewData: ReviewData) {
    Text(
        modifier = Modifier.padding(top = 20.dp, start = 24.dp),
        text = reviewData.title,
        fontSize = 16.sp,
        fontWeight = FontWeight.W700,
        color = reviewTitleColor
    )

    Row(modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 12.dp, bottom = 8.dp)) {
        Text(
            text = reviewData.ratingText,
            fontSize = 48.sp,
            fontWeight = FontWeight.W700,
            color = Color.White
        )
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.CenterVertically)
        ) {
            RatingBar(
                modifier = Modifier.layoutId("rating"),
                value = reviewData.ratingFloat,
                config = RatingBarConfig()
                    .style(RatingBarStyle.Normal)
                    .size(12.dp)
                    .padding(2.dp),
                onValueChange = {},
                onRatingChanged = {}
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = reviewData.countReviews,
                fontSize = 12.sp,
                fontWeight = FontWeight.W400,
                color = reviewTextColor
            )
        }
    }

    reviewData.itemReview.forEachIndexed { index, item ->
        ReviewCell(item)
        if (index != reviewData.itemReview.size - 1) {
            Divider(
                modifier = Modifier.padding(top = 24.dp, start = 38.dp, end = 38.dp),
                color = dividerColor
            )
        }
    }
}

@Composable
fun ReviewCell(reviewItem: ReviewItem) {
    val constraintSet = ConstraintSet {
        val avatar = createRefFor("avatar")
        val name = createRefFor("name")
        val date = createRefFor("date")
        val reviewText = createRefFor("reviewText")

        constrain(avatar) {
            top.linkTo(name.top)
            start.linkTo(parent.start)
            bottom.linkTo(date.bottom)
        }

        constrain(name) {
            top.linkTo(parent.top)
            start.linkTo(avatar.end, 16.dp)
        }

        constrain(date) {
            top.linkTo(name.bottom, 6.dp)
            start.linkTo(avatar.end, 16.dp)
        }

        constrain(reviewText) {
            top.linkTo(date.bottom, 16.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, top = 24.dp, end = 24.dp),
        constraintSet = constraintSet
    ) {
        Image(
            modifier = Modifier
                .layoutId("avatar")
                .size(36.dp),
            painter = painterResource(id = reviewItem.avatar),
            contentDescription = "avatar",
            contentScale = ContentScale.FillBounds
        )

        Text(
            modifier = Modifier.layoutId("name"),
            text = reviewItem.name,
            fontSize = 16.sp,
            fontWeight = FontWeight.W400,
            color = Color.White
        )

        Text(
            modifier = Modifier.layoutId("date"),
            text = reviewItem.date,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = dateReviewColor
        )

        Text(
            modifier = Modifier.layoutId("reviewText"),
            text = reviewItem.description,
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            color = reviewTextColor
        )
    }
}