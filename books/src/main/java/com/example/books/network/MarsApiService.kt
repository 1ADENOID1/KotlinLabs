package com.example.books.network


import com.example.books.data.AppContainer
import com.example.books.data.MarsPhotosRepository
import com.example.books.data.NetworkMarsPhotosRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


import retrofit2.http.GET

class DefaultAppContainer : AppContainer {
    private val BASE_URL =
        "https://android-kotlin-fun-mars-server.appspot.com"

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
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

