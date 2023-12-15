package com.turkoglu.composedeneme.domain.model

import com.turkoglu.composedeneme.data.remote.dto.Genre
import com.turkoglu.composedeneme.data.remote.dto.ProductionCompany
import com.turkoglu.composedeneme.data.remote.dto.ProductionCountry

data class MovieDetail(
    val adult: Boolean,
    val backdropPath: String,
    val genres: List<Genre>,
    val imdbId: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<ProductionCompany>,
    val productionCountries: List<ProductionCountry>,
    val releaseDate: String,
    val revenue: Int,
    val title: String,
    val voteAverage: Double
)
