package id.melur.hitachitest.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.melur.hitachitest.database.UserDao
import id.melur.hitachitest.database.UserDatabase
import id.melur.hitachitest.database.UserDetailDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): UserDatabase =
        Room.databaseBuilder(context, UserDatabase::class.java, "User.db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideUserDao(database: UserDatabase): UserDao =
        database.userDao()

    @Provides
    @Singleton
    fun provideUserDetailDao(database: UserDatabase): UserDetailDao =
        database.userDetailDao()

}