package id.melur.hitachitest.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.melur.hitachitest.helper.DataRepo
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val dataRepo: DataRepo,
) : ViewModel() {

    fun getData() = dataRepo.getAllData()

    fun getUserData(username : String) = dataRepo.getUserData(username)

    fun getUser(username : String) = dataRepo.getUser(username)
}