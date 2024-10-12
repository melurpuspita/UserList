package id.melur.hitachitest.helper

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import id.melur.hitachitest.database.User
import id.melur.hitachitest.database.UserDao
import id.melur.hitachitest.model.UserItem
import id.melur.hitachitest.service.ApiService
import javax.inject.Inject

class DataRepo @Inject constructor(
    private val apiService: ApiService,
    private val userDao: UserDao
) {
    
    fun getAllData(): LiveData<Result<List<User>>> = liveData {
        emit(Result.Loading)
        try {
            val response = apiService.getData().toList()

            val data = response.map { user ->
                user.toDataEntity()
            }

            userDao.deleteAllData()
            userDao.insertAPIData(data)
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
        val localData: LiveData<Result<List<User>>> =
            userDao.getData().map { Result.Success(it) }
        emitSource(localData)
    }

    fun getUserData(username: String) : LiveData<Result<UserItem>> = liveData {
        emit(Result.Loading)
        try {
            val response = apiService.getUserById(username)
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }
}