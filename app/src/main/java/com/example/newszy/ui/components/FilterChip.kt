package com.example.newszy.ui.components


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChipComponent(
    category: String,
    isSelected: Boolean = false,
    onSelectedCategoryChange: (String) -> Unit) {

    FilterChip(
        modifier = Modifier
            .padding(end = 8.dp),
        selected = isSelected,
        label = { Text(text = category) },
        onClick = { onSelectedCategoryChange(category) },
        elevation = FilterChipDefaults.filterChipElevation(),
        leadingIcon = {
            if (isSelected) {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        }

    )
}