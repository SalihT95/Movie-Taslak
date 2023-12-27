package com.turkoglu.composedeneme.presentation.home.view

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.turkoglu.composedeneme.domain.model.Movie
import com.turkoglu.composedeneme.presentation.home.HomeViewModel
import com.turkoglu.composedeneme.presentation.home.MovieListItem


@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToDetail: (Movie) -> Unit

) {
    val state = viewModel.state.value
    val stateTopRated = viewModel.stateTopRated.value
    val stateNowPlaying = viewModel.stateNowPlaying.value
    val stateUpcoming = viewModel.stateUpcoming.value

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        LazyColumn {
            //-------------------TopRated-----------------------
            item(content = {
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp), // Sayfa kenarlarından padding
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Trending today", color = Color.White, fontSize = 18.sp)

                    Text(
                        text = "View All",
                        color = Color.White,
                        fontSize = 18.sp,
                        modifier = Modifier.clickable {
                            //navigate to viewAll
                        })

                }


                //Spacer(modifier = Modifier.height(8.dp))
            })
            item(content = {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(220.dp),
                    contentAlignment = Alignment.Center
                ) {
                    LazyRow(content = {

                        itemsIndexed(
                            stateTopRated.movies,
                            key = { _: Int, movie: Movie -> movie.id }) { index, movie ->
                            MovieListItem(
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(180.dp),
                                movie = movie,
                                onMovieClick = {navigateToDetail(movie)}
                            )
                        }
                    })
                }
            })
            // ----------------Popular-----------------------
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp), // Sayfa kenarlarından padding
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Popular", color = Color.White, fontSize = 18.sp)

                    Text(
                        text = "View All",
                        color = Color.White,
                        fontSize = 18.sp,
                        modifier = Modifier.clickable {
                            //navigate to viewAll
                        })

                }
            }

            item {
                Spacer(modifier = Modifier.height(5.dp))

                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(210.dp),
                    contentAlignment = Alignment.Center
                ) {
                    LazyHorizontalGrid(
                        rows = GridCells.Fixed(1),

                        ) {

                        itemsIndexed(
                            state.movies,
                            key = { _: Int, movie: Movie -> movie.id }) { index, movie ->
                            MovieListItem(
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(180.dp),
                                movie = movie,
                                onMovieClick = {navigateToDetail(movie)}
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
            // --------------NowPlaying----------------------

            item {
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp), // Sayfa kenarlarından padding
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Now Playing", color = Color.White, fontSize = 18.sp)

                    Text(
                        text = "View All",
                        color = Color.White,
                        fontSize = 18.sp,
                        modifier = Modifier.clickable {
                            //navigate to viewAll
                        })

                }
            }

            item {
                Spacer(modifier = Modifier.height(5.dp))

                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(210.dp),
                    contentAlignment = Alignment.Center
                ) {
                    LazyHorizontalGrid(
                        rows = GridCells.Fixed(1),

                        ) {

                        itemsIndexed(
                            stateNowPlaying.movies,
                            key = { _: Int, movie: Movie -> movie.id }) { index, movie ->
                            MovieListItem(
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(180.dp),
                                movie = movie,
                                onMovieClick = {navigateToDetail(movie)}
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
            //------------Upcoming-----------------

            item {
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp), // Sayfa kenarlarından padding
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "UpComing", color = Color.White, fontSize = 18.sp)

                    Text(
                        text = "View All",
                        color = Color.White,
                        fontSize = 18.sp,
                        modifier = Modifier.clickable {
                            //navigate to viewAll
                        })

                }
            }

            item {
                Spacer(modifier = Modifier.height(5.dp))

                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(210.dp),
                    contentAlignment = Alignment.Center
                ) {
                    LazyHorizontalGrid(
                        rows = GridCells.Fixed(1),

                        ) {

                        itemsIndexed(
                            stateUpcoming.movies,
                            key = { _: Int, movie: Movie -> movie.id }) { index, movie ->
                            MovieListItem(
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(180.dp),
                                movie = movie,
                                onMovieClick = {navigateToDetail(movie)}
                            )
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
