package com.example.newszy.ui.screens.home

sealed class HomeScreenEvent{

    data class OnSelectedCategory(val category :String ) : HomeScreenEvent()

    data class OnSelectedHeadlineCountry(val country : String) : HomeScreenEvent()

    data class OnSelectedMainNewsCountry(val country : String) : HomeScreenEvent()
}