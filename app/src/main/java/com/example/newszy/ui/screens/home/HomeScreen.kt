package com.example.newszy.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newszy.ui.components.CategoryChip
import com.example.newszy.ui.components.headLine.HeadLineTextSection
import com.example.newszy.ui.components.headLine.headLineSection
import com.example.newszy.ui.components.mainNewsSection.MainNewsTextSection


data class News(
    val articles: List<Article>,
    val status: String,
    val totalResult: Int
)

data class Article(
    val author: String,
    val content: String,
    val description: String,
    val source: Source
)

data class Source(
    val id: Int,
    val name: String
)

@Composable
fun HomeScreen() {

    val category: List<String> = listOf(
        "business",
        "entertainment",
        "general",
        "health",
        "science",
        "sports",
        "technology"
    )

    val countryNames = listOf(
        "United Arab Emirates",
        "Argentina",
        "Austria",
        "Australia",
        "Belgium",
        "Bulgaria",
        "Brazil",
        "Canada",
        "Switzerland",
        "China",
        "Colombia",
        "Cuba",
        "Czech Republic",
        "Germany",
        "Egypt",
        "France",
        "United Kingdom",
        "Greece",
        "Hong Kong",
        "Hungary",
        "Indonesia",
        "Ireland",
        "Israel",
        "India",
        "Italy",
        "Japan",
        "South Korea",
        "Lithuania",
        "Latvia",
        "Morocco",
        "Mexico",
        "Malaysia",
        "Nigeria",
        "Netherlands",
        "Norway",
        "New Zealand",
        "Philippines",
        "Poland",
        "Portugal",
        "Romania",
        "Serbia",
        "Russia",
        "Saudi Arabia",
        "Sweden",
        "Singapore",
        "Slovenia",
        "Slovakia",
        "Thailand",
        "Turkey",
        "Taiwan",
        "Ukraine",
        "United States",
        "Venezuela",
        "South Africa"
    )

    var selectedCategoryForHeadLine by remember { mutableStateOf("") }


    var selectedCountryTextForHeadLine by remember { mutableStateOf("") }


    var selectedCountryTextForMainNews by remember { mutableStateOf("") }


    val article = listOf(
        Article(
            author = "John Doe",
            content = "Lorem ipsum content 1",
            description = "Description 1",
            source = Source(id = 1, name = "Source A")
        ),
        Article(
            author = "Alice Smith",
            content = "Lorem ipsum content 2",
            description = "Description 2",
            source = Source(id = 2, name = "Source B")
        ),
        Article(
            author = "Bob Johnson",
            content = "Lorem ipsum content 3",
            description = "Description 3",
            source = Source(id = 3, name = "Source C")
        ),
        Article(
            author = "Eva Williams",
            content = "Lorem ipsum content 4",
            description = "Description 4",
            source = Source(id = 4, name = "Source D")
        ),
        Article(
            author = "Michael Brown",
            content = "Lorem ipsum content 5",
            description = "Description 5",
            source = Source(id = 5, name = "Source E")
        ),
        Article(
            author = "Sophia Davis",
            content = "Lorem ipsum content 6",
            description = "Description 6",
            source = Source(id = 6, name = "Source F")
        ),
        Article(
            author = "David Miller",
            content = "Lorem ipsum content 7",
            description = "Description 7",
            source = Source(id = 7, name = "Source G")
        ),
        Article(
            author = "Emma Wilson",
            content = "Lorem ipsum content 8",
            description = "Description 8",
            source = Source(id = 8, name = "Source H")
        ),
        Article(
            author = "Daniel Jackson",
            content = "Lorem ipsum content 9",
            description = "Description 9",
            source = Source(id = 9, name = "Source I")
        ),
        Article(
            author = "Olivia White",
            content = "Lorem ipsum content 10",
            description = "Description 10",
            source = Source(id = 10, name = "Source J")
        )
    )

    val news = News(articles = article, status = "ok", totalResult = 20)


    Scaffold(
        topBar = {
            HomeScreenTopBar()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .padding(10.dp)
        ) {

            // Category Section
            CategoryChip(
                category = category,
                selectedCategory = selectedCategoryForHeadLine,
                onSelectedCategoryChange = { selectedCategoryForHeadLine = it }
            )

            LazyColumn {

                item {
                    //HeadLine Text Section
                    HeadLineTextSection(
                        countryNames = countryNames,
                        selectedCountry = selectedCountryTextForHeadLine,
                        onSelectedCountryChange = {
                            selectedCountryTextForHeadLine = it
                        }
                    )
                }

                item {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(3 / 2f)
                    ) {
                        //HeadLine Section
                        headLineSection(news.articles)
                    }
                }

                //Main Section

                item {
                    //Headline Text for Main news
                    MainNewsTextSection(
                        countryNames = countryNames,
                        selectedCountry = selectedCountryTextForMainNews,
                        onSelectedCountryChange = {
                            selectedCountryTextForMainNews = it
                        }
                    )
                }

            }


        }
    }

}


//Top Bar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreenTopBar() {
    TopAppBar(title = {
        Text(
            text = "Newszy",
            style = MaterialTheme.typography.displayMedium
        )
    }
    )
}
































