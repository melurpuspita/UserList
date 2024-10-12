package id.melur.hitachitest.model

import com.google.gson.annotations.SerializedName
import id.melur.hitachitest.database.UserDetail

data class UserItem(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("blog")
    val blog: String,
    @SerializedName("company")
    val company: String,
    @SerializedName("followers")
    val followers: Int,
    @SerializedName("following")
    val following: Int,
    @SerializedName("location")
    val location: String,
    @SerializedName("login")
    val login: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("public_gists")
    val publicGists: Int,
    @SerializedName("public_repos")
    val publicRepos: Int
) {
    fun toDataEntity(): UserDetail =
        UserDetail(
            id = id,
            avatarUrl = avatarUrl,
            blog = blog,
            company = company,
            followers = followers,
            following = following,
            location = location,
            login = login,
            name = name,
            publicGists = publicGists,
            publicRepos = publicRepos
        )
}