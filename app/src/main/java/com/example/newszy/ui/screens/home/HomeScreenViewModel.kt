package com.example.newszy.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newszy.data.NewsRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.stateIn
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

            }
            is HomeScreenEvent.OnSelectedHeadlineCountry -> TODO()
            is HomeScreenEvent.OnSelectedMainNewsCountry -> TODO()
        }
    }

}