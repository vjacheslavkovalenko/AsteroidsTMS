package by.vjacheslavkovalenko.asteroidstms.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity

@Dao
interface AsteroidsDao {

    @Insert
    suspend fun insertList(list: List<AsteroidsEntity>)

    @Query("SELECT * FROM Asteroids")
    suspend fun getListAsteroids(): List<AsteroidsEntity>

    @Query("SELECT * FROM Asteroids")
    fun pagingSource(): PagingSource<Int, AsteroidsEntity>

    @Query("SELECT * FROM Asteroids WHERE asteroidId = :id")
    suspend fun getAsteroidById(id: String): AsteroidsEntity?
}