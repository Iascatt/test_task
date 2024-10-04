package com.example.emtesttask.domain.models

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Vacancy(
    @SerializedName("id") val id: String,
    @SerializedName("lookingNumber") val lookingNumber: Int,
    @SerializedName("title") val title: String,
    @SerializedName("address") val address: Address,
    @SerializedName("company") val company: String,
    @SerializedName("experience") val experience: Experience,
    @SerializedName("publishedDate") val publishedDate: Date,
    @SerializedName("isFavorite") val isFavorite: Boolean,
    @SerializedName("salary") val salary: Salary,
    @SerializedName("appliedNumber") val appliedNumber: Int,
    @SerializedName("description") val description: String,
    @SerializedName("responsibilities") val responsibilities: String,
    @SerializedName("questions") val questions: List<String>
)
