package id.melur.hitachitest.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.melur.hitachitest.database.UserDao
import id.melur.hitachitest.database.UserDetailDao
import id.melur.hitachitest.helper.DataRepo
import id.melur.hitachitest.service.ApiService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(apiService: ApiService, userDao: UserDao, userDetailDao: UserDetailDao) =
        DataRepo(apiService, userDao, userDetailDao)
}