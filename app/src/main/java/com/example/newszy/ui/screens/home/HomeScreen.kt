package com.example.newszy.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.newszy.ui.components.headLine.headLineSection
import com.example.newszy.ui.components.CategoryChip
import com.example.newszy.ui.components.headLine.HeadLineTextSection

@Composable
fun HomeScreen() {

    val category : List<String> = listOf(
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

    var selectedCategory by remember { mutableStateOf("") }

    var selectedCountryText by remember { mutableStateOf("") }


    Scaffold(
        topBar = {
            HomeScreenTopBar()
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .padding(10.dp)
        ) {

            item {
                // Category Section
                CategoryChip(
                    category = category,
                    selectedCategory = selectedCategory,
                    onSelectedCategoryChange = { selectedCategory = it}
                )

                //HeadLine Text Section
                HeadLineTextSection(
                    countryNames = countryNames,
                    selectedCountry = selectedCountryText,
                    onSelectedCountryChange ={
                        selectedCountryText = it
                    }
                )
            }

            //HeadLine Section
            headLineSection()

            //Main Section

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
































