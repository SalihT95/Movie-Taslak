package com.turkoglu.composedeneme.presentation.home.view

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bumptech.glide.load.HttpException
import com.turkoglu.composedeneme.R
import com.turkoglu.composedeneme.domain.model.Movie
import com.turkoglu.composedeneme.presentation.home.HomeViewModel
import com.turkoglu.composedeneme.presentation.home.MovieListItem
import java.io.IOException


@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()

) {

    val topRatedMovies = viewModel.state2.value.movies
    val state2 = viewModel.state2.value
    val state = viewModel.state.value
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        LazyColumn {
            item(content = {
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Trending today", color = Color.White, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(8.dp))
            })
            item(content = {
                Spacer(modifier = Modifier.height(5.dp))
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(220.dp),
                    contentAlignment = Alignment.Center
                ) {
                    LazyRow(content = {

                        itemsIndexed(state2.movies, key = { _: Int, movie: Movie -> movie.id }) { index, movie ->
                            MovieListItem(
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(130.dp),
                                movie = movie
                            ) {}
                        }
                    })
                }
            })
            // ----------------Popular-----------------------
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Popular", color = Color.White, fontSize = 18.sp)
            }

            item {
                Spacer(modifier = Modifier.height(5.dp))

                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(210.dp),
                    contentAlignment = Alignment.Center
                ) {
                    LazyRow {

                        itemsIndexed(state.movies, key = { _: Int, movie: Movie -> movie.id }) { index, movie ->
                            MovieListItem(
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(130.dp),
                                movie = movie
                            ) {}
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }

    /*
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(state.movies, key = { _: Int, movie: Movie -> movie.id }) { index, movie ->
                MovieListItem(movie = movie, onMovieClick = {})
                println(movie.imageUrl)
            }


        }
    }*/
}
