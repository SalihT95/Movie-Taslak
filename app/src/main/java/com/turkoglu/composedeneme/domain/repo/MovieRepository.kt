package com.turkoglu.composedeneme.domain.repo

interface MovieRepository {

    suspend fun getMovies()//: MoviesDto
    suspend fun getMovieDetail()//: MovieDetailDto


}