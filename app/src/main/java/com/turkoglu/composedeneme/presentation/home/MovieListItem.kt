package com.turkoglu.composedeneme.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.turkoglu.composedeneme.R
import com.turkoglu.composedeneme.domain.model.Movie
import coil.compose.*


@Composable
fun MovieListItem(
    modifier: Modifier = Modifier,
    movie: Movie,
    onMovieClick: (Movie) -> Unit
) {
    Card(
        modifier = modifier
            .height(220.dp)
            .clickable { onMovieClick(movie) },
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Box(
                modifier = modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(model = movie.posterImage, contentDescription = movie.title,
                    modifier= Modifier.fillMaxSize().clip(RoundedCornerShape(bottomStart = 2.dp, bottomEnd = 2.dp))
                )
                Surface(
                    color = Color.Black.copy(alpha = 0.6f),
                    modifier = modifier
                        .size(50.dp),
                    shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.heart),
                        contentDescription = null,
                        modifier = modifier
                            .padding(12.dp)
                            .align(Alignment.TopEnd)
                    )
                }
            }

            Column(
                modifier = modifier.padding(10.dp)
            ){
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = modifier.height(4.dp))

                Text(text = movie.releaseDate, style = MaterialTheme.typography.titleMedium)
            }
        }
    }

}