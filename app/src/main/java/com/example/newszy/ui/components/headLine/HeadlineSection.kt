package com.example.newszy.ui.components.headLine

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newszy.R
import com.example.newszy.domain.model.Article
import com.example.newszy.util.formatDateString
import okhttp3.internal.wait

fun LazyListScope.headLineSection(articles: List<Article> , onCardSelected : (String) -> Unit) {
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
            HeadLineArticleCard(article = article , onCardSelected = onCardSelected)
        }
    }
}


@Composable
fun HeadLineArticleCard(article: Article , onCardSelected : (String) -> Unit) {
    val imageRequest = ImageRequest.Builder(LocalContext.current)
        .data(data =article.urlToImage )
        .crossfade(true)
        .build()

    ElevatedCard(
        modifier = Modifier
            .padding(10.dp)
            .width(290.dp)
            .shadow(
                elevation = 7.dp,
                ambientColor = Color.White,
                spotColor = Color.White,
                shape = RoundedCornerShape(15.dp)
            ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
            pressedElevation = 0.dp
        ),
        shape = RoundedCornerShape(15.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .clickable {
                    onCardSelected(article.url)
                },
        ){
            AsyncImage(
                model = imageRequest ,
                contentDescription = "Image",
                contentScale = ContentScale.FillBounds
            )
//            Image(
//                modifier = Modifier
//                    .fillMaxSize(),
//                painter = painterResource(id =R.drawable.test) ,
//                contentDescription = "back ground image",
//                contentScale = ContentScale.FillBounds
//            )
            HeadLineArticleCardTitleAndDate(
                title = article.title,
                date = article.publishedAt
            )

        }
    }
}

@Composable
private fun HeadLineArticleCardTitleAndDate(
    title : String,
    date : String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.End),
            text = date
                .formatDateString(),
            style = TextStyle(
                fontSize = 10.sp,
                shadow = Shadow ( color= Color.Black, blurRadius = 15f)
            ),
            color = Color.White,
        )
        Text(
            modifier = Modifier
                .align(Alignment.Start)
                .background(Color.Transparent.copy(alpha = 0.25f)),
            text = title,
            style = TextStyle(
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                shadow = Shadow ( color= Color.Black, blurRadius = 15f )
            ),
            color = Color.White
        )
    }
}