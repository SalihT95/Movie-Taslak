package com.turkoglu.composedeneme.domain.repo

import com.turkoglu.composedeneme.data.remote.dto.MovieDetailDto
import com.turkoglu.composedeneme.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(): MoviesDto

    suspend fun getMovieDetail(imdbId:String): MovieDetailDto

}