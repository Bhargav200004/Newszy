package com.example.newszy.domain.repository

import com.example.newszy.domain.model.NewsFetch

interface NewsRepository{

    suspend fun getHeadlines(country : String , category : String) : NewsFetch
    suspend fun getEveryThing(q : String = "title") : NewsFetch
}