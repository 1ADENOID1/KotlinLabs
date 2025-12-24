package com.example.mars.network


import com.example.mars.data.AppContainer
import com.example.mars.data.MarsPhotosRepository
import com.example.mars.data.NetworkMarsPhotosRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


import retrofit2.http.GET
import retrofit2.http.Path

class DefaultAppContainer : AppContainer {
    private val BASE_URL =
        "https://www.googleapis.com/books/v1/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())    // Конвертер из урока не хотел работать, заменил на православный Gson
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }

    override val marsPhotosRepository: MarsPhotosRepository by lazy {
        NetworkMarsPhotosRepository(retrofitService)
    }
}
interface MarsApiService {
    @GET("volumes?q=jazz+history")
    suspend fun getBooks(): BooksInfo

    @GET("volumes/{id}")
    suspend fun getImage(@Path("id") id: String): List<BookVolume>

    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

