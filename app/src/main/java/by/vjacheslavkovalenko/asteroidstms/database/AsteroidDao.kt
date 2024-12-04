package by.vjacheslavkovalenko.asteroidstms.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import by.vjacheslavkovalenko.asteroidstms.domain.Asteroid

@Dao
interface AsteroidDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(asteroids: List<Asteroid>)

    @Query("SELECT * FROM asteroid_table")
    suspend fun getAllAsteroids(): List<Asteroid>
}