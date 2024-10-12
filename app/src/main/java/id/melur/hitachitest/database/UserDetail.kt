package id.melur.hitachitest.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_d")
data class UserDetail(
    @PrimaryKey
    @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "avatar_url") var avatarUrl: String,
    @ColumnInfo(name = "blog") var blog: String,
    @ColumnInfo(name = "company") var company: String,
    @ColumnInfo(name = "followers") var followers: Int,
    @ColumnInfo(name = "following") var following: Int,
    @ColumnInfo(name = "location") var location: String,
    @ColumnInfo(name = "login") var login: String,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "public_gists") var publicGists: Int,
    @ColumnInfo(name = "public_repos") var publicRepos: Int
)
