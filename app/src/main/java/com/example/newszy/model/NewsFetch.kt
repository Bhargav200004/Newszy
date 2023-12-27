package com.example.newszy.model


import com.google.gson.annotations.SerializedName

data class NewsFetch(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)