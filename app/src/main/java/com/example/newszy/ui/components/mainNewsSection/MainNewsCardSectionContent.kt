package com.example.newszy.ui.components.mainNewsSection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.newszy.R
import com.example.newszy.domain.model.Article


fun LazyListScope.mainNewsCardSectionContent(articles: List<Article>) {
    if (articles.isEmpty()) {
        item {
            Image(
                modifier = Modifier
                    .fillParentMaxWidth()
                    .height(280.dp),
                painter = painterResource(id = R.drawable.nonews),
                contentDescription = "",
                contentScale = ContentScale.Fit
            )
        }
    }
    else{
        items(articles) { article ->
            MainNewsCardSectionContentCard(article = article)
        }
    }
}

@Composable
private fun MainNewsCardSectionContentCard(article: Article) {
    ElevatedCard{
        Column {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth(),
                model = article.urlToImage,
                contentDescription = "Image"
            )
//            Image(
//                modifier = Modifier
//                    .fillMaxWidth(),
//                painter = painterResource(id = R.drawable.test),
//                contentDescription = ""
//            )
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Text(
                        text = article.title,
                        textDecoration = TextDecoration.Underline
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = article.content ?: "Not Available",
                        style = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp),
                        color = Color.Gray
                    )
                }

            }
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}