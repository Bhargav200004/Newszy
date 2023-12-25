package com.example.newszy.ui.components.headLine

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.newszy.R
import com.example.newszy.ui.screens.home.Article

fun LazyListScope.headLineSection(articles: List<Article>) {
    items(articles){
        HeadLineArticleCard()
    }
}


@Composable
fun HeadLineArticleCard() {
    ElevatedCard(
        modifier = Modifier
            .padding(8.dp)
            .width(270.dp),
    ) {
        Box(modifier = Modifier.fillMaxSize()){
//            AsyncImage(model = articles., contentDescription = )
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(id =R.drawable.ic_launcher_background) ,
                contentDescription = "back ground image",
                contentScale = ContentScale.FillBounds
            )

            Row {
                Text(
                    text = "Title",
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = "2023-12-24T18:30:35Z"
                )
            }
        }
    }
}


