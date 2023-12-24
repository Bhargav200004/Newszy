package com.example.newszy.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun CategoryChip(category: List<String> ,selectedCategory : String, onSelectedCategoryChange : (String) -> Unit ) {


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
            FilterChipComponent(
                category = it,
                isSelected = selectedCategory == it,
                onSelectedCategoryChange =onSelectedCategoryChange
            )
        }
    }
}