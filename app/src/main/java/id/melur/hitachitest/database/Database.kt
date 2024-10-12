package id.melur.hitachitest.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [User::class, UserDetail::class], version = 3, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun userDetailDao(): UserDetailDao

}