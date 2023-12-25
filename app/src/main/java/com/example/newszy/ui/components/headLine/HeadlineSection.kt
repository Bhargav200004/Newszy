package com.example.newszy.ui.components.headLine

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newszy.R
import com.example.newszy.ui.screens.home.Article
import com.example.newszy.util.formatDateString

fun LazyListScope.headLineSection(articles: List<Article>) {
    items(5){
        HeadLineArticleCard()
    }
}


@Composable
fun HeadLineArticleCard() {
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
                .clickable {},
        ){
//            AsyncImage(model = articles., contentDescription = )
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(id =R.drawable.test) ,
                contentDescription = "back ground image",
                contentScale = ContentScale.FillBounds
            )
            HeadLineArticleCardTitleAndDate(
                title = "Pistons match NBA single-season losing streak record with 26th straight defeat - The Athletic",
                date = "2023-12-24T18:30:35Z"
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
                .align(Alignment.Start),
            text = title,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                shadow = Shadow ( color= Color.Black, blurRadius = 15f )
            ),
            color = Color.White
        )
    }
}


