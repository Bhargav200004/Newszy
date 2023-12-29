package com.example.newszy.ui.screens.home

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

    fun onEvent(event : HomeScreenEvent){
        when(event){
            is HomeScreenEvent.OnSelectedCategory -> {
                _state.update { homeScreenState->
                    homeScreenState.copy(
                        selectedCategory = event.category
                    )
                }
            }
            is HomeScreenEvent.OnSelectedHeadlineCountry -> {
                _state.update { homeScreenState->
                    homeScreenState.copy(
                        headlineCountry = event.country
                    )
                }
            }
            is HomeScreenEvent.OnSelectedMainNewsCountry -> {
                _state.update { homeScreenState->
                    homeScreenState.copy(
                        mainNewsCountry = event.country

                    )
                }
                country(state.value.mainNewsCountry)
            }
        }
    }

    private fun country(mainNewsCountry: String) {
        val country = HomeScreenState.getCountry(mainNewsCountry)
        Log.d("countryCode" , "countryCode = $country")
    }

}