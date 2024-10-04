package com.example.emtesttask.domain.models

import com.google.gson.annotations.SerializedName

data class Salary(
    @SerializedName("short") val short: String?,
    @SerializedName("full") val full: String
)
