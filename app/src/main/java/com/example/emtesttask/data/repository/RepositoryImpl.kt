package com.example.plantingapp.data.repository

import com.example.emtesttask.data.Api
import com.example.emtesttask.domain.models.Info
import retrofit2.Response



class RepositoryImpl(
    private val api: Api
) : Repository {
    override suspend fun getInfo(): Response<Info> {
        return api.getInfoFromMock()
    }
}