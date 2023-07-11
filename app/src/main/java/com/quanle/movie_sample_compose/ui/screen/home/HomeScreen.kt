package com.quanle.movie_sample_compose.ui.screen.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quanle.movie_sample_compose.R
import com.quanle.movie_sample_compose.ui.screen.components.MovieComponent

@Composable
fun HomeScreen(state: () -> Unit) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
    ) {
        Banner(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDes = "ah",
            modifier = Modifier.height(350.dp)
        )

        HomeListMovie(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            title = "Top 10 Movies This Week",
            movies = 10,
            onSeeAll =  {
                state()
            }
        )

        Spacer(modifier = Modifier
            .height(8.dp)
            .background(Color.LightGray))

        HomeListMovie(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.Red),
            title = "New Releases",
            movies = 3,
            onSeeAll =  {

            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        HomeListMovie(
            modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .wrapContentHeight(),
            title = "Top pick",
            movies = 3,
            onSeeAll =  {

            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        HomeListMovie(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            title = "Alo 1 2 1 2",
            movies = 3,
            onSeeAll =  {

            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        HomeListMovie(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            title = "New Releases",
            movies = 3,
            onSeeAll =  {

            }
        )
    }

}

@Composable
fun Banner(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDes: String
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {

        Image(
            painter = painter,
            contentDescription = contentDes,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Row {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "App Icon",
                    tint = Color.Red,
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "App Icon",
                    modifier = Modifier.size(24.dp),
                    tint = Color.White
                )

                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "App Icon",
                    modifier = Modifier.size(24.dp),
                    tint = Color.White
                )
            }

            Column {
                Text(
                    text = "Dr Strange",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight(800),
                )

                Text(
                    text = "hahashdhashdhasdhashdhashdahsd",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    modifier = Modifier.padding(horizontal = 0.dp, vertical = 4.dp)
                )

                Row {
                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(24.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Red,
                            contentColor = Color.White
                        )
                    ) {
                        Card(
                            shape = CircleShape
                        ) {
                            Icon(
                                imageVector = Icons.Filled.PlayArrow,
                                contentDescription = "contentDescription",
                                tint = Color.Red,
                                modifier = Modifier
                                    .size(ButtonDefaults.IconSize)
                                    .padding(4.dp)
                            )
                        }
                        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                        Text(text = "Play")
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(24.dp),
                        border = BorderStroke(ButtonDefaults.outlinedBorder.width, Color.White),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Transparent,
                            contentColor = Color.White
                        ),
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "contentDescription",
                            tint = Color.White,
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                        Text(text = "My list")
                    }
                }
            }
        }

    }
}

@Composable
fun HomeListMovie(
    modifier: Modifier = Modifier,
    title: String,
    onSeeAll: () -> Unit,
    movies: Int //mock
) {
    Column(
        modifier = modifier
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                color = Color.Black
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "See all",
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                color = Color.Red,
                modifier = Modifier.clickable { onSeeAll() }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 8.dp)
        ) {
            items(movies) {
                MovieComponent(
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun ComposablePreview() {
}
