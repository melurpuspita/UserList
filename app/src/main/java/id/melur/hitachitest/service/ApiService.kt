package id.melur.hitachitest.service

import id.melur.hitachitest.model.DataResponse
import id.melur.hitachitest.model.UserItem
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    @GET("users")
    suspend fun getData() : DataResponse

    @GET("users/{username}")
    suspend fun getUserById(
        @Path("username") username: String
    ): UserItem
}