package by.vjacheslavkovalenko.asteroidstms.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.vjacheslavkovalenko.asteroidstms.database.entity.PictureOfDayEntity

@Dao
interface PictureOfDayDao {

    @Insert
    suspend fun insertPictureOfDay(pictureOfDay: PictureOfDayEntity)

    @Query("SELECT * FROM PictureOfDay LIMIT 1")
    suspend fun getPictureOfDay(): PictureOfDayEntity?
}