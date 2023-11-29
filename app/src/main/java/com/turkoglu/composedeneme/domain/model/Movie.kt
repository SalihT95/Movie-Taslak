package com.turkoglu.composedeneme.domain.model

data class Movie (
    val id: Int,
    val overview: String,
    val popularity: Double,
    val posterImage: String,
    val releaseDate: String,
    val title: String
)