package com.turkoglu.composedeneme.data.repo

import com.turkoglu.composedeneme.data.remote.MovieAPI
import com.turkoglu.composedeneme.data.remote.dto.MovieDetailDto
import com.turkoglu.composedeneme.data.remote.dto.MoviesDto
import com.turkoglu.composedeneme.domain.repo.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api : MovieAPI): MovieRepository {
    override suspend fun getMovies(): MoviesDto {
        return api.getPopularMovies()
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return api.getMovieDetail(imdbId)
    }
}