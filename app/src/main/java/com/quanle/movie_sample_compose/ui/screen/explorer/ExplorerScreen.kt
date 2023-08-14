package com.quanle.movie_sample_compose.ui.screen.explorer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quanle.movie_sample_compose.R
import com.quanle.movie_sample_compose.ui.screen.components.ChipComponent
import com.quanle.movie_sample_compose.ui.screen.components.InputView
import com.quanle.movie_sample_compose.ui.screen.components.LayoutButton
import com.quanle.movie_sample_compose.ui.screen.components.MovieCard
import com.quanle.movie_sample_compose.utils.wtf
import kotlinx.coroutines.launch

@Composable
@Preview
fun explorerScreenPreview(){
   ExplorerScreen(onMovieClicked = { /*TODO*/ })
   // FilterOptionsBottomSheet(Modifier)

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExplorerScreen(
    modifier: Modifier = Modifier,
    onMovieClicked: () -> Unit,
    items: Int = 0
) {
    var focusCleared by remember { mutableStateOf(false) }
    var searchValue by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true
    )

    ModalBottomSheetLayout(
        modifier = Modifier
            .clickable { focusCleared = true }
            .fillMaxSize()
            .background(Color.White),
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        sheetBackgroundColor = Color.White,
        sheetElevation = 0.dp,
        sheetContent = {
            FilterOptionsBottomSheet(
                modifier = Modifier
                    .fillMaxHeight(0.9f)
            )
        },
        content = { /** Content of Explorer Screen **/

            SearchBar(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                isFocusCleared = focusCleared,
                onFocusCleared = { focusCleared = false },
                text = searchValue,
                onTextChanged = {searchValue = it},
                onSearch = {
                           wtf { it }
                },
                onFilterClicked = {
                    coroutineScope.launch {
                        if (modalSheetState.isVisible)
                            modalSheetState.hide()
                        else
                            modalSheetState.show()
                    }
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(
                content = {
                    items(count = items) {
                        ChipComponent(
                            content = if (it % 3 != 0) "asdasdasda" else "Quan",
                            isSelected = it % 2 == 0
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            if (items > 0) {
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    columns = GridCells.Fixed(2),
                    content = {
                        items(30) {
                            MovieCard(
                                modifier = Modifier
                                    .height(250.dp)
                                    .clickable {
                                        onMovieClicked()
                                    }
                            )
                        }
                    }
                )
            } else {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    painter = painterResource(id = R.drawable.ic_empty_list),
                    contentDescription = ""
                )
            }
        }
    )
}

@Composable
fun SearchBar(
    modifier: Modifier,
    text: String,
    onTextChanged: (String) -> Unit,
    onSearch: (String) -> Unit,
    onFilterClicked: () -> Unit,
    onFocusCleared:  () -> Unit,
    isFocusCleared: Boolean,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        InputView(
            modifier = Modifier
                .fillMaxWidth(0.83f)
                .padding(end = 12.dp),
            hint = "Search",
            leadingIcon = R.drawable.ic_search,
            text = text,
            onTextChanged = onTextChanged,
            imeAction = ImeAction.Search,
            onSearch = { value ->
                onSearch(value)
            },
            isFocusCleared =  isFocusCleared,
            onFocusCleared = onFocusCleared
        )

        Row(
            modifier = Modifier
                .clickable { onFilterClicked() }
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFFCE7E9))
                .height(TextFieldDefaults.MinHeight)
                .fillMaxWidth(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
            ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_filter),
                tint = Color.Red,
                contentDescription = ""
            )
        }
    }
}

@Composable
fun FilterOptionsBottomSheet(
    modifier: Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.15f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Sort & Filter",
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,

            )
        }

        Divider()

        Column(
            Modifier
                .padding(
                    vertical = 12.dp,
                    horizontal = 16.dp
                )
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .weight(0.7f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            FilterOptions(modifier = Modifier)

            FilterOptions(modifier = Modifier)

            FilterOptions(modifier = Modifier)

            FilterOptions(modifier = Modifier)

            FilterOptions(modifier = Modifier)
        }

        Divider()

        Spacer(modifier = Modifier.height(12.dp))

        LayoutButton(
            modifier = Modifier
                .weight(0.15f),
            primaryContent = "asdasd",
            onPrimaryActionClicked = {

            },
            secondaryContent = "asdasd",
            onSecondaryActionClicked = {

            }
        )
    }
}

@Composable
fun FilterOptions(
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Categories",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,

        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            content = {
                items(count = 10) {
                    ChipComponent(
                        content = "Option",
                        isSelected = false
                    )
                }
            }
        )

    }
}