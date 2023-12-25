package com.turkoglu.composedeneme.domain.repo

import com.turkoglu.composedeneme.data.remote.dto.MovieDetailDto
import com.turkoglu.composedeneme.data.remote.dto.MoviesDto

interface MovieRepository {
    suspend fun getMovies(page : Int): MoviesDto
    suspend fun getTopRatedMovies(page : Int): MoviesDto

    suspend fun getNowPlayingMovies(page : Int): MoviesDto

    suspend fun getUpcomingMovies(page : Int): MoviesDto
    suspend fun getMovieDetail(imdbId:String): MovieDetailDto

}