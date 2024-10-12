package id.melur.hitachitest.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getData(): LiveData<List<User>>

    @Query("SELECT * FROM user WHERE login LIKE '%' || :username || '%'")
    fun getDataByUsername(username: String): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAPIData(user: List<User>)

    @Query("DELETE FROM user")
    suspend fun deleteAllData()
}