package id.melur.hitachitest.service

import id.melur.hitachitest.model.DataResponse
import retrofit2.http.GET

interface ApiService {
    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    @GET("users")
    suspend fun getData() : DataResponse
}