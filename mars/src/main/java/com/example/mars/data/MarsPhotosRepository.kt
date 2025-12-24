package com.example.mars.data

import com.example.mars.network.BookVolume
import com.example.mars.network.Item
import com.example.mars.network.MarsApiService
import com.example.mars.network.MarsPhoto

interface MarsPhotosRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>

    suspend fun getBookIds(): List<Item>

    suspend fun getBookImages(id: String): List<BookVolume>

}

class NetworkMarsPhotosRepository(
    private val marsApiService: MarsApiService
) : MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> = marsApiService.getPhotos()
    override suspend fun getBookIds(): List<Item> {
        val booksInfo = marsApiService.getBooks()
        return booksInfo.items
    }

    override suspend fun getBookImages(id: String): List<BookVolume> {
        return marsApiService.getImage(id)
    }
}