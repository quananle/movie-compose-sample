package com.quanle.movie_sample_compose.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quanle.movie_sample_compose.R

@Preview(showBackground = true)
@Composable
fun MovieComponentPreView() {
    Movie(modifier = Modifier.height(150.dp))
}

@Composable
fun Movie(
    modifier: Modifier
) {

    Row(
        modifier = modifier
    ) {

        MovieThumbnail(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 8.dp,
                    bottom = 8.dp,
                    start = 8.dp,
                    end = 4.dp
                )
                .weight(0.45f),
            painter = painterResource(id = R.drawable.img_onboard_1))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 8.dp,
                    vertical = 16.dp
                )
                .weight(0.6f),
            verticalArrangement = Arrangement.SpaceAround
        ) {

            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .padding(end = 8.dp),
                    text = "Stranger Things",
                    maxLines = 2,
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight(600),
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start
                )

                Text(
                    text = "04/08/2023",
                    fontSize = 8.sp,
                    color = Color.Gray,
                    maxLines = 1
                )
            }

            Text(
                text = "Episode 8",
                fontSize = 12.sp,
                color = Color.Black,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start,
            )

            Text(
                text = "asdasd",
                fontSize = 12.sp,
                color = Color.Red,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFFCE7E9))
                    .padding(
                        vertical = 4.dp,
                        horizontal = 8.dp
                    )
            )

        }
        
    }

}

@Composable
fun MovieThumbnail(
    modifier: Modifier,
    painter: Painter,
    contentDesc: String = "",
    episodeTitle: String? = null
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp)
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painter,
                contentDescription = contentDesc,
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_play_transparent),
                tint= Color.Unspecified,
                contentDescription = ""
            )

            Text(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp),
                text = episodeTitle ?: "",
                fontSize = 16.sp
            )
        }
    }
}
