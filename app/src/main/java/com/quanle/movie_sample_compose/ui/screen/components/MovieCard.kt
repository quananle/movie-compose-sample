package com.quanle.movie_sample_compose.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quanle.movie_sample_compose.R

@Composable
fun MovieCard(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Card(
            shape = RoundedCornerShape(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_onboard_1),
                contentDescription = "movie rate",
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color.Red,
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text ="9.8",
                color = Color.White,
                fontSize = 8.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
@Preview
fun singleMovie() {
    MovieCard()
}
