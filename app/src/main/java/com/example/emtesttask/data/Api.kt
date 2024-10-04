package com.example.emtesttask.data

import com.example.emtesttask.domain.models.Info
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("u/0/uc?id=1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r&export=download")
    suspend fun getInfoFromMock(): Response<Info>
}
