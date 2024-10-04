package com.example.emtesttask.domain.models

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("offers") val offers: List<Offer>,
    @SerializedName("vacancies") val vacancies: List<Vacancy>
)