package id.melur.hitachitest.model

import com.google.gson.annotations.SerializedName
import id.melur.hitachitest.database.User

data class DataItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String
) {
    fun toDataEntity(): User =
        User(
            id = id,
            login = login,
            avatarUrl = avatarUrl
        )
}