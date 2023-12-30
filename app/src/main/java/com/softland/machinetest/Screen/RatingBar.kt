package com.softland.machinetest.Screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.softland.machinetest.R
import java.lang.Math.ceil
import java.lang.Math.floor


@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    stars: Int = 5,
    starsColor: Color = Color.Yellow,
) {
    val filledStars = floor(rating).toInt()
    val unfilledStars = (stars - ceil(rating)).toInt()
    val halfStar = !(rating.rem(1).equals(0.0))
    Row(modifier = modifier) {
        repeat(filledStars) {
            Icon(imageVector = Icons.Outlined.Star, contentDescription = null, tint = starsColor)
        }
        if (halfStar) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.star_half),
                contentDescription = null,
                tint = starsColor,
                modifier = Modifier
                    .size(21.dp).padding(top = 2.dp) // Set the desired height and width (24.dp in this example)
            )

        }
        repeat(unfilledStars) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.star_outline_svgrepo_com),
                contentDescription = null,
                tint = starsColor,
                modifier = Modifier
                    .size(20.dp).padding(top = 2.1.dp)
            )
        }
    }
}
@Preview
@Composable
fun RatingPreview() {
    RatingBar(rating = 2.5)
}
@Preview
@Composable
fun TenStarsRatingPreview() {
    RatingBar(stars = 10, rating = 8.5)
}
@Preview
@Composable
fun RatingPreviewFull() {
    RatingBar(rating = 5.0)
}
@Preview
@Composable
fun RatingPreviewWorst() {
    RatingBar(rating = 1.0)
}
@Preview
@Composable
fun RatingPreviewDisabled() {
    RatingBar(rating = 0.0, starsColor = Color.Gray)
}