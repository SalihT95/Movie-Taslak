package com.turkoglu.composedeneme.data.remote

import com.google.gson.annotations.SerializedName

data class SpokenLanguage(
    @SerializedName("english_name")
    val englishName: String?,
)
