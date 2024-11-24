package by.vjacheslavkovalenko.asteroidstms.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidDetailsEntity

@Dao
interface AsteroidDetailsDao {

    @Insert
    suspend fun insertAsteroidDetails (asteroidDetails: AsteroidDetailsEntity)

    @Query("SELECT * FROM AsteroidDetails WHERE asteroidId == :asteroidId LIMIT 1")
    suspend fun getAsteroidDetailsById(asteroidId: String): AsteroidDetailsEntity
}