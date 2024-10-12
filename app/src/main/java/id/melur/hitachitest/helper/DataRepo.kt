package id.melur.hitachitest.helper

import id.melur.hitachitest.database.UserDao
import id.melur.hitachitest.service.ApiService
import javax.inject.Inject

class DataRepo @Inject constructor(
    private val apiService: ApiService,
    private val userDao: UserDao
) {


}