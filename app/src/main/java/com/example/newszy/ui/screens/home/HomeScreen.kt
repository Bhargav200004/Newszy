package com.example.newszy.ui.screens.home

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newszy.ui.components.FilterChipComponent
import com.example.newszy.ui.components.headLineSection

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
                CategoryChip(category, isSelected = {})
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "HeadLine",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }

            //HeadLine Section
            headLineSection()

            //Main Section

        }
    }

}

@Composable
private fun CategoryChip(category: List<String> , isSelected : (String) -> Unit) {
    Text(
        text = "Category",
        style = MaterialTheme.typography.titleSmall
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        category.forEach {
            FilterChipComponent(label = it, onClick = isSelected)
        }
    }
}


//Top Bar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreenTopBar() {
    TopAppBar(title = { Text(
        text = "Newszy",
        style = MaterialTheme.typography.displayMedium
    ) })

}
































