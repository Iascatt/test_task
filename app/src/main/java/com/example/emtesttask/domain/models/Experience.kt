package com.example.emtesttask.domain.models

import com.google.gson.annotations.SerializedName

data class Experience(
    @SerializedName("previewText") val previewText: String,
    @SerializedName("text") val text: String,
)
