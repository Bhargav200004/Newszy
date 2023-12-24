package com.example.newszy.ui.components.headLine

import android.util.Log
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
fun HeadLineTextSection(countryNames: List<String> , selectedCountry  : String , onSelectedCountryChange : (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "HeadLines",
            style = MaterialTheme.typography.headlineMedium
        )
        DropDownMenu(
            options = countryNames,
            selectedOption = selectedCountry,
            onSelectedOptionChange = onSelectedCountryChange
        )
    }
}