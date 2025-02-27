package com.example.emtesttask.domain.models

import com.google.gson.annotations.SerializedName

data class Offer(
    @SerializedName("id") val id: String?,
    @SerializedName("title") val title: String,
    @SerializedName("button") val button: Button?,
    @SerializedName("link") val link: String
)