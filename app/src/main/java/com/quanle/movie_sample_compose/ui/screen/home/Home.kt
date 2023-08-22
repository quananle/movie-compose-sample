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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.quanle.movie_sample_compose.R
import com.quanle.movie_sample_compose.data.remote.response.Movie
import com.quanle.movie_sample_compose.data.remote.utils.Result
import com.quanle.movie_sample_compose.ui.screen.components.MovieCard
import com.quanle.movie_sample_compose.utils.SourceImage
import com.quanle.movie_sample_compose.utils.toImageUri
import com.quanle.movie_sample_compose.utils.wtf

@Composable
@Preview
fun HomePreview() {

    HomeListMovie(
        title = "asdasd",
        onClickedSeeAll = { /*TODO*/ },
        onClickedDetailMovie = { /*TODO*/ },
        movies = listOf()
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier,
    scrollState: ScrollState = rememberScrollState(),
    onClickedDiscoverMovie: () -> Unit,
    onClickedSearch: () -> Unit,
    onClickedNotification: () -> Unit,
    onClickedDetailMovie: () -> Unit
) {
    val viewmodel: HomeViewModel = hiltViewModel()
    val uiState = viewmodel.homeUiState.collectAsState()


    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
    ) { /** HomeScreen with component **/
        
        Banner(
            painter = uiState.value.topRatedMovies?.get(0)?.backdrop_path?.toImageUri(SourceImage.LARGE) ?: "",
            contentDes = "ah",
            modifier = Modifier
                .height(330.dp)
                .fillMaxHeight(0.4f),
            onClickedSearch = {
                onClickedSearch()
            },
            onClickedNotification = {
                onClickedNotification()
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        HomeListMovie(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            title = "Top 10 Movies This Week",
            movies = uiState.value.popularMovies ?: listOf(),
            onClickedSeeAll =  {
                onClickedDiscoverMovie()
            },
            onClickedDetailMovie = {
                onClickedDetailMovie()
            }
        ) // end of New Releases

        HomeListMovie(
            movies = uiState.value.topRatedMovies ?: listOf(),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            title = "Top 10 Movies This Week",
            onClickedSeeAll =  {
                onClickedDiscoverMovie()
            },
            onClickedDetailMovie = {
                onClickedDetailMovie()
            }
        )

        HomeListMovie(
            movies = uiState.value.topRatedMovies ?: listOf(),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            title = "Top 10 Movies This Week",
            onClickedSeeAll =  {
                onClickedDiscoverMovie()
            },
            onClickedDetailMovie = {
                onClickedDetailMovie()
            }
        )

        HomeListMovie(
            movies = uiState.value.topRatedMovies ?: listOf(),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            title = "Top 10 Movies This Week",
            onClickedSeeAll =  {
                onClickedDiscoverMovie()
            },
            onClickedDetailMovie = {
                onClickedDetailMovie()
            }
        )

        HomeListMovie(
            movies = uiState.value.topRatedMovies ?: listOf(),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            title = "Top 10 Movies This Week",
            onClickedSeeAll =  {
                onClickedDiscoverMovie()
            },
            onClickedDetailMovie = {
                onClickedDetailMovie()
            }
        )
    }

}

@Composable
fun Banner(
    modifier: Modifier = Modifier,
    painter: String,
    contentDes: String = "",
    onClickedSearch: () -> Unit,
    onClickedNotification: () -> Unit
) {
    Box(
        modifier = modifier
    ) {

        AsyncImage(
            model = painter,
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

            Row (
                modifier = Modifier.padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.app_icon),
                    contentDescription = "App Icon",
                    modifier = Modifier.size(40.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "App Icon",
                    tint = Color.White,
                    modifier = Modifier
                        .size(26.dp)
                        .clickable {
                            onClickedSearch()
                        }
                )

                Spacer(modifier = Modifier.width(20.dp))

                Icon(
                    painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = "App Icon",
                    tint = Color.White,
                    modifier = Modifier
                        .size(28.dp)
                        .clickable {
                            onClickedNotification()
                        }
                )
            }

            Column {
                Text(
                    text = "Dr Strange",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W800,
                )

                Text(
                    text = "hahashdhashdhasdhashdhashdahsd",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    modifier = Modifier.padding(bottom = 4.dp)
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
    onClickedSeeAll: () -> Unit,
    onClickedDetailMovie: () -> Unit,
    movies: List<Movie>
) {
    Column(
        modifier = modifier
    ) {
        Row (
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                color = Color.Black
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "See all",
                fontSize = 12.sp,
                fontWeight = FontWeight(600),
                color = Color.Red,
                modifier = Modifier.clickable { onClickedSeeAll() }
            )
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            items(movies.size) {index ->
                MovieCard(
                    modifier = Modifier
                        .height(200.dp)
                        .width(150.dp)
                        .clickable {
                            onClickedDetailMovie()
                        },
                    movie = movies[index]
                )
            }
        }
    }
}
