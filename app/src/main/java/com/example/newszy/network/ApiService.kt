package com.example.newszy.network

import com.example.newszy.domain.model.NewsFetch
import com.example.newszy.util.Constant
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService{

    @Headers("X-Api-Key: ${Constant.API_KEY}")
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country  : String,
        @Query("category") category : String
    ) : NewsFetch


    @Headers("X-Api-Key: ${Constant.API_KEY}")
    @GET("everything")
    suspend fun getEveryThing(
        @Query("q") q: String = "title",
    ): NewsFetch



}