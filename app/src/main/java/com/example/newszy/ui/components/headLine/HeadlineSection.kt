package com.example.newszy.ui.components.headLine

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import com.example.newszy.ui.screens.home.News

fun LazyListScope.headLineSection(newsAll: List<News>) {
    newsAll.forEach{news->
        items(news.articles){

        }
    }



}


