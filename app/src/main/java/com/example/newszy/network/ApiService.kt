package com.example.newszy.network

import com.example.newszy.domain.model.NewsFetch
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService{

//    https://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=7f7b1a2cfbf94040b6018162e83d3497

//    @Headers("X-Api-Key: 7f7b1a2cfbf94040b6018162e83d3497")
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country  : String,
        @Query("category") category : String
    ) : NewsFetch

//    https://newsapi.org/v2/everything?q=title&apiKey=7f7b1a2cfbf94040b6018162e83d3497

//    @Headers("X-Api-Key: 7f7b1a2cfbf94040b6018162e83d3497")
    @GET("everything")
    suspend fun getEveryThing(
        @Query("q") q: String = "title",
    ): NewsFetch



}