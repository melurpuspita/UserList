package id.melur.hitachitest.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDetailDao {
    @Query("SELECT * FROM user_d WHERE login = :login")
    fun getData(login: String): LiveData<UserDetail>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAPIData(userDetail: UserDetail)
}