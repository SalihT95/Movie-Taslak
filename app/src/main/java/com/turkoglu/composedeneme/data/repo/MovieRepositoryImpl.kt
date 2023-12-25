package com.turkoglu.composedeneme.data.repo

import com.turkoglu.composedeneme.data.remote.MovieAPI
import com.turkoglu.composedeneme.data.remote.dto.MovieDetailDto
import com.turkoglu.composedeneme.data.remote.dto.MoviesDto
import com.turkoglu.composedeneme.domain.repo.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api : MovieAPI): MovieRepository {
    override suspend fun getMovies(page : Int): MoviesDto {
        return api.getPopularMovies(page)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return api.getMovieDetail(imdbId)
    }
    override suspend fun getTopRatedMovies(page: Int): MoviesDto {
        return api.getTopRatedMovies(page)
    }

    override suspend fun getNowPlayingMovies(page: Int): MoviesDto {
        return api.getNowPlayingMovies(page)
    }

    override suspend fun getUpcomingMovies(page: Int): MoviesDto {
        return api.getUpcomingMovies(page)
    }
}