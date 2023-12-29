package com.example.newszy.data

import com.example.newszy.domain.model.NewsFetch
import com.example.newszy.domain.repository.NewsRepository
import com.example.newszy.network.ApiService
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : NewsRepository{
    override suspend fun getHeadlines(country: String, category: String): NewsFetch {
        return apiService.getTopHeadlines(country = country, category = category)
    }

    override suspend fun getEveryThing(q: String): NewsFetch {
        return apiService.getEveryThing(q = q)
    }
}