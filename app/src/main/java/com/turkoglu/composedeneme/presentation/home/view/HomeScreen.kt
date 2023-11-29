package com.turkoglu.composedeneme.presentation.home.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.turkoglu.composedeneme.R

/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeScreenState,
    loadNextMovies: (Boolean) -> Unit,
    navigateToDetail: (Movie) -> Unit
) {

    //CenterText(text = "Home")
    val isRefreshing by remember {
        mutableStateOf(false)
    }

    val state = rememberPullRefreshState(refreshing = isRefreshing, onRefresh = {})

    val pullRefreshState = rememberPullRefreshState(refreshing = uiState!!.refreshing,
        onRefresh = { loadNextMovies(true) })

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .pullRefresh(state = pullRefreshState)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(
                uiState.movies,
                key = { _, movie -> movie.id }
            ) { index, movie ->
                MovieListItem(movie = movie, onMovieClick = { navigateToDetail(movie) })

                if (index >= uiState.movies.size - 1 && !uiState.loading && !uiState.loadFinished) {
                    LaunchedEffect(key1 = Unit, block = { loadNextMovies(false) })
                }
            }

            if (uiState.loading && uiState.movies.isNotEmpty()) {
                item(span = { GridItemSpan(2) }) {
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CircularProgressIndicator(
                            color = Red
                        )
                    }
                }
            }
        }

        PullRefreshIndicator(
            refreshing = uiState.refreshing,
            state = pullRefreshState,
            modifier = modifier.align(Alignment.TopCenter)
        )
    }


}

 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {



    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {


                item(span = { GridItemSpan(2) }) {
                    Column(
                        modifier = modifier
                            .fillMaxWidth(0.5f)
                            .padding(16.dp),

                        //horizontalArrangement = Arrangement.Center,
                        //verticalAlignment = Alignment.CenterVertically
                    ) {
                        //CenterText(text = "Home")
                        val painter = painterResource(id = R.drawable.kd4)
                        Box(modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .padding(16.dp)){
                            ImageCard(
                                painter = painter,
                                title ="Kutsal Damacana 4"
                            )
                        }

                        Box(modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .padding(16.dp)){
                            ImageCard(
                                painter = painter,
                                title ="Kutsal Damacana 4"
                            )
                        }
                    }



                }

        }
    }


}

@Composable
fun ImageCard(
    painter : Painter,
    title : String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxSize(),
        shape = RoundedCornerShape(15.dp),
        elevation =  CardDefaults.cardElevation(
            defaultElevation = 5.dp)
    ) {
        Box (modifier = Modifier.height(200.dp)){
            Image(
                painter = painter,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

            Box (modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f
                    )
                )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomCenter
            ){
                Text(text = title, style = TextStyle(color = Color.White), fontSize = 16.sp)
            }

        }

    }

}