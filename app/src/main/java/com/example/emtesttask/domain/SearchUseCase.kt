package com.example.emtesttask.domain

import android.util.Log
import com.example.emtesttask.domain.models.Info
import com.example.plantingapp.data.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class SearchUseCase (
    private val repository: Repository
) {
    fun getInfo(): Flow<State<Info>> = flow {
        try {
            emit(State.Loading())
            val response = repository.getInfo()
            if (response.isSuccessful) {
                emit(State.Success(response.body()))
            } else {
                emit(State.Error(message = response.message()))
            }
        } catch (e: Exception) {
            emit(State.Error(e.localizedMessage))
        }
    }
}