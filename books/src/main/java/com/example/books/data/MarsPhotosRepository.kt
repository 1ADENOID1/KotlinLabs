package com.example.books.data

import com.example.books.network.BookVolume
import com.example.books.network.Item
import com.example.books.network.MarsApiService


interface MarsPhotosRepository {

    suspend fun getBookIds(): List<Item>
    suspend fun getBookImages(id: String): BookVolume

}

class NetworkMarsPhotosRepository(
    private val marsApiService: MarsApiService
) : MarsPhotosRepository {
    override suspend fun getBookIds(): List<Item> {
        val booksInfo = marsApiService.getBooks()
        return booksInfo.items
    }

    override suspend fun getBookImages(id: String): BookVolume {
        return marsApiService.getImage(id)

    }
}