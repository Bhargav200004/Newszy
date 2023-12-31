package com.example.newszy.ui.screens.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newszy.data.NewsRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val newsRepositoryImpl: NewsRepositoryImpl
) :ViewModel() {

    private val _state = MutableStateFlow(HomeScreenState())

    val state = _state.asSharedFlow().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
        initialValue = HomeScreenState()
    )

    init {
        getMainCountryNews(
            category = state.value.selectedCategory
        )
        getHeadlineNews(
            category = state.value.selectedCategory,
            country = state.value.headlineCountry
        )

    }

    fun onEvent(event : HomeScreenEvent){
        when(event){
            is HomeScreenEvent.OnSelectedCategory -> {
                _state.update { homeScreenState->
                    homeScreenState.copy(
                        selectedCategory = event.category
                    )
                }
                getMainCountryNews(
                    category = state.value.selectedCategory
                )
            }
            is HomeScreenEvent.OnSelectedHeadlineCountry -> {
                _state.update { homeScreenState->
                    homeScreenState.copy(
                        headlineCountry = event.country
                    )
                }
                getHeadlineNews(
                    category = state.value.selectedCategory,
                    country = state.value.headlineCountry
                )
            }
            is HomeScreenEvent.OnSelectedMainNewsCountry -> {
                 _state.update { homeScreenState->
                    homeScreenState.copy(
                        mainNewsCountry = event.country
                    )
                }
            }

            is HomeScreenEvent.OnSelectedCard -> {
                _state.update {homeScreenState ->
                    homeScreenState.copy(
                        url = event.uri
                    )
                }
                goToUrl(
                    context = event.context,
                    url = state.value.url
                )
            }
        }
    }

    private fun goToUrl(context: Context , url: String) {
        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(webIntent)

    }

    private fun getHeadlineNews(category: String , country: String) {
        val headlineCategory  = HomeScreenState.getCategory(category)
        val headlineCountry = HomeScreenState.getCountry(country)
        viewModelScope.launch {
            try {
                val state = newsRepositoryImpl.getHeadlines(country = headlineCountry.toString() , category = headlineCategory.toString())
                _state.update {homeScreenState ->
                    homeScreenState.copy(
                     headlineArticle = state.articles
                    )
                }
            }
            catch(e : Exception) {
                Log.d("headlineNewsError", "${e.message}")
            }
        }

    }

    private fun getMainCountryNews(category : String) {
        val mainCategory = HomeScreenState.getCategory(category)
        viewModelScope.launch {
            try {
                val state = newsRepositoryImpl.getEveryThing(q = mainCategory.toString())
                _state.update {homeScreenState->
                    homeScreenState.copy(
                        mainNewsArticle = state.articles
                    )
                }
            }
            catch (e : Exception){
                Log.e("getMainCountryError =" , "${e.message}")
            }


        }
    }

}