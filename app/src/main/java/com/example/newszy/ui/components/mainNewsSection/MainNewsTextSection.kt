package com.example.newszy.ui.components.mainNewsSection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.newszy.ui.components.DropDownMenu

@Composable
fun MainNewsTextSection(countryNames: List<String> , selectedCountry  : String , onSelectedCountryChange : (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "News",
            style = MaterialTheme.typography.headlineMedium
        )
        DropDownMenu(
            options = countryNames,
            selectedOption = selectedCountry,
            onSelectedOptionChange = onSelectedCountryChange
        )
    }
}