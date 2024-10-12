package id.melur.hitachitest.helper

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import id.melur.hitachitest.database.User
import id.melur.hitachitest.database.UserDao
import id.melur.hitachitest.database.UserDetail
import id.melur.hitachitest.database.UserDetailDao
import id.melur.hitachitest.service.ApiService
import javax.inject.Inject

class DataRepo @Inject constructor(
    private val apiService: ApiService,
    private val userDao: UserDao,
    private val userDetailDao: UserDetailDao
) {
    
    fun getAllData(): LiveData<Result<List<User>>> = liveData {
        emit(Result.Loading)
        try {
            val response = apiService.getData().toList()

            val data = response.map { user ->
                user.toDataEntity()
            }

            userDao.insertAPIData(data)
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
        val localData: LiveData<Result<List<User>>> =
            userDao.getData().map { Result.Success(it) }
        emitSource(localData)
    }

    fun getUserData(username: String) : LiveData<Result<UserDetail>> = liveData {
        emit(Result.Loading)
        try {

            val response = apiService.getUserById(username)

            val data = response.toDataEntity()
            userDetailDao.insertAPIData(data)

        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
        val localData: LiveData<Result<UserDetail>> =
            userDetailDao.getData(username).map { Result.Success(it) }
        emitSource(localData)
    }

    fun getUser(username: String) : LiveData<Result<List<User>>> = liveData {
        emit(Result.Loading)
        try {
            val localData: LiveData<Result<List<User>>> =
                userDao.getDataByUsername(username).map { Result.Success(it) }
            emitSource(localData)
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }
}