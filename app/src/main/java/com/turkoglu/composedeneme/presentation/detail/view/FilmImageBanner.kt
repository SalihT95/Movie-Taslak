package com.turkoglu.composedeneme.presentation.detail.view

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.turkoglu.composedeneme.presentation.detail.DetailScreenViewModel

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun FilmImageBanner(
    scrollState: LazyListState,
    posterUrl: String,
    filmName: String,
    filmId: Int,
    filmType: String,
    releaseDate: String,
    rating: Float,
    viewModel: DetailScreenViewModel

) {

    val state = viewModel.state.value
    val context = LocalContext.current

    TopAppBar(
        contentPadding = PaddingValues(),
        backgroundColor = Color.Red,
        modifier = Modifier
            .height(400.dp),
        elevation = 4.dp
    ) {
        Column {
            Box {
                AsyncImage(
                    model = state.image,
                    modifier = Modifier
                        .fillMaxSize()
                        .height(200.dp)
                        .graphicsLayer {
                            alpha = 1f - 200
                        },
                    contentScale = ContentScale.Crop,
                    contentDescription = "Movie Banner"
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colorStops = arrayOf(
                                    Pair(0.3f, Transparent),
                                    Pair(1.5f, Color.Magenta)
                                )
                            )
                        )
                )
                FilmNameAndRating(
                    filmName = filmName,
                    rating = rating
                )
            }
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(horizontal = 10.dp)
    ) {
        CircularBackButtons(
            onClick = {
                //navigator.popBackStack()
            }
        )
    }
}