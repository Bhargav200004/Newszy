package com.example

import com.example.newszy.model.NewsFetch
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService{

    @Headers("X-Api-Key: 7f7b1a2cfbf94040b6018162e83d3497")
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("q") q: String,
    ): NewsFetch

}