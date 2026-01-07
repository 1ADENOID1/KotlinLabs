package com.example.books.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


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
    @SerialName("volumeInfo") val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    @SerialName("imageLinks") val imageLinks: ImageLink
)

@Serializable
data class ImageLink(
    @SerialName("thumbnail") val thumbnail: String)
