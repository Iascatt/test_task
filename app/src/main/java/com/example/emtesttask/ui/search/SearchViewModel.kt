package com.example.emtesttask.ui.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.emtesttask.domain.SearchUseCase
import com.example.emtesttask.domain.State
import com.example.emtesttask.domain.models.Info
import com.example.emtesttask.ui.UiState
import com.example.plantingapp.data.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel (
    repository: Repository
) : ViewModel() {
    private val searchUseCase = SearchUseCase(repository)

    private val _loadingStates = MutableStateFlow(UiState.NotLoading)
    val loadingStates = _loadingStates.asStateFlow()
    val _info: MutableStateFlow<Info?> = MutableStateFlow(null)
    val info = _info.asStateFlow()

    private val _errorMsg: MutableStateFlow<String?> = MutableStateFlow(null)

    fun loadInfo() {
        viewModelScope.launch {
            searchUseCase.getInfo()
                .collect {
                    when (it) {
                        is State.Error -> {
                            _loadingStates.value = UiState.Error
                            _errorMsg.value = it.message
                            Log.d("loading info", "error: ${it.message}")

                        }

                        is State.Loading -> _loadingStates.value = UiState.Loading

                        is State.Success -> {
                            _info.value = it.data
                            _loadingStates.value = UiState.Success
                            Log.d("loading info", "success: ${info.value}")
                        }

                        is State.Empty -> {
                            _info.value = null
                            _loadingStates.value = UiState.Empty
                        }
                    }
                }
        }
    }

    fun favouriteVacancies() = info.value?.vacancies?.filter { it.isFavorite }


    init {
        loadInfo()
    }
}