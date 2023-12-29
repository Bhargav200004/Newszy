package com.example.newszy.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.newszy.ui.components.CategoryChip
import com.example.newszy.ui.components.headLine.HeadLineTextSection
import com.example.newszy.ui.components.headLine.headLineSection
import com.example.newszy.ui.components.mainNewsSection.MainNewsTextSection
import com.example.newszy.ui.components.mainNewsSection.mainNewsCardSectionContent


@Composable
fun HomeScreenNavigation() {
    val viewModel: HomeScreenViewModel = hiltViewModel()

    val state by viewModel.state.collectAsStateWithLifecycle()

    HomeScreen(
        state = state,
        onEvent = viewModel::onEvent
    )

}

@Composable
fun HomeScreen(
    state: HomeScreenState,
    onEvent : (HomeScreenEvent) -> Unit
) {
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
                category = state.category,
                selectedCategory = state.selectedCategory,
                onSelectedCategoryChange = { onEvent(HomeScreenEvent.OnSelectedCategory(it)) }
            )

            LazyColumn {

                item {
                    //HeadLine Text Section
                    HeadLineTextSection(
                        countryNames = state.countryList,
                        selectedCountry = state.headlineCountry,
                        onSelectedCountryChange = {onEvent(HomeScreenEvent.OnSelectedHeadlineCountry(it))}
                    )
                }

                item {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(3 / 2f)
                    ) {
                        //HeadLine Section
                        headLineSection(articles = state.headlineArticle)
                    }
                }

                //Main Section

                item {
                    //Headline Text for Main news
                    MainNewsTextSection(
                        countryNames = state.countryList,
                        selectedCountry = state.mainNewsCountry,
                        onSelectedCountryChange = { onEvent(HomeScreenEvent.OnSelectedMainNewsCountry(it))}
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }

                //Main News Card Section
                mainNewsCardSectionContent(articles = state.mainNewsArticle)

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
































