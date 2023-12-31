package com.example.newszy.ui.screens.home

import android.content.Context

sealed class HomeScreenEvent{

    data class OnSelectedCategory(val category :String ) : HomeScreenEvent()

    data class OnSelectedHeadlineCountry(val country : String) : HomeScreenEvent()

    data class OnSelectedMainNewsCountry(val country : String) : HomeScreenEvent()

    data class OnSelectedCard(val uri : String , val context: Context) : HomeScreenEvent()
}