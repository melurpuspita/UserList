package id.melur.hitachitest.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.melur.hitachitest.database.UserDao
import id.melur.hitachitest.helper.DataRepo
import id.melur.hitachitest.service.ApiService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(apiService: ApiService, userDao: UserDao) =
        DataRepo(apiService, userDao)
}