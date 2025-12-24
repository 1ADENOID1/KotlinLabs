package com.example.mars.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarsPhoto(
    @SerialName(value = "id")
    val id: String,
    @SerialName(value = "img_src")
    val img_src: String
)

@Serializable
data class BooksInfo(
    @SerialName("items") val items: List<Item>
)

@Serializable
data class Item(
    @SerialName("id") val id: String
)

@Serializable
data class BookVolume(
    @SerialName("id") val id: String,
    @SerialName("volumeInfo") val volumeInfo: List<VolumeInfo>
)

@Serializable
data class VolumeInfo(
    @SerialName("imageLinks") val imageLinks: List<ImageLink>
)

@Serializable
data class ImageLink(
    @SerialName("thumbnail") val thumbnail: String
)