package com.example.podlodkaComposeDota2.data.model

import com.example.podlodkaComposeDota2.R


data class GameDetailsData(
    val posterWithInformation: PosterWithInformationData,
    val genreList: List<String>,
    val description: String,
    val videoList: List<Int>,
    val reviewData: ReviewData
) {
    companion object {
        fun createExample() = GameDetailsData(
            posterWithInformation = PosterWithInformationData.createExample(),
            genreList = listOf("MOBA", "MULTIPLAYER", "STRATEGY"),
            description = "Dota 2 is a multiplayer online battle arena (MOBA) game which has two teams of five players compete to collectively destroy a large structure defended by the opposing team known as the \"Ancient\", whilst defending their own.",
            videoList = listOf(R.drawable.video_preview1, R.drawable.video_preview2),
            reviewData = ReviewData.createExample()
        )
    }
}

data class ReviewData(
    val title: String,
    val ratingText: String,
    val ratingFloat: Float,
    val countReviews: String,
    val itemReview: List<ReviewItem>
) {
    companion object {
        fun createExample() = ReviewData(
            title = "Review & Ratings",
            ratingText = "4.9",
            ratingFloat = 4.5f,
            countReviews = "70M Reviews",
            itemReview = listOf(
                ReviewItem(
                    name = "Auguste Conte",
                    date = "February 14, 2019",
                    description = "“Once you start to learn its secrets, there’s a wild and exciting variety of play here that’s unmatched, even by its peers.”",
                    avatar = R.drawable.avatar1
                ),
                ReviewItem(
                    name = "Jang Marcelino",
                    date = "February 14, 2019",
                    description = "“Once you start to learn its secrets, there’s a wild and exciting variety of play here that’s unmatched, even by its peers.”",
                    avatar = R.drawable.avatar2
                )
            )
        )
    }
}

data class ReviewItem(
    val name: String,
    val date: String,
    val description: String,
    val avatar: Int
)

data class PosterWithInformationData(
    val posterId: Int,
    val gameLogo: Int,
    val nameGame: String,
    val ratingGame: Float,
    val countReview: String
) {
    companion object {
        fun createExample() = PosterWithInformationData(
            posterId = R.drawable.details_image,
            gameLogo = R.drawable.dota_logo,
            nameGame = "DoTA 2",
            ratingGame = 5.0f,
            countReview = "70M"
        )
    }
}
