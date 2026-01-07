package com.example.books.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarsPhoto(
    @SerialName(value = "id")
    val id: String,
    @SerialName(value = "img_src")
    val img_src: String
)
