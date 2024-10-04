package com.example.plantingapp.data.repository

import com.example.emtesttask.domain.models.Info
import retrofit2.Response

interface Repository {
    suspend fun getInfo(): Response<Info>
}