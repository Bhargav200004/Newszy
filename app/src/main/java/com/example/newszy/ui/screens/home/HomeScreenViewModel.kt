package com.example.newszy.ui.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newszy.data.NewsRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val newsRepositoryImpl: NewsRepositoryImpl
) :ViewModel() {

    fun test(){
        try {
            viewModelScope.launch {
                val news = newsRepositoryImpl.getHeadlines(country = "in", category = "sports")
                Log.d("success",news.articles.toString())
            }
        }
        catch (e: Exception){
            Log.e("error","${e.message}")
        }
    }

}