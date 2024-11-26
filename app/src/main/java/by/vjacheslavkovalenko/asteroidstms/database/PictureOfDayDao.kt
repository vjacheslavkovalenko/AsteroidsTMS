package by.vjacheslavkovalenko.asteroidstms.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.vjacheslavkovalenko.asteroidstms.database.entity.PictureOfDayEntity

@Dao
interface PictureOfDayDao {

    @Insert
    suspend fun insertPictureOfDay(pictureOfDay: PictureOfDayEntity)

    //@Query("SELECT * FROM Picture pod ORDER BY pod.date DESC LIMIT 0,1")
    @Query("SELECT * FROM Picture LIMIT 1")
    suspend fun getPictureOfDay(): PictureOfDayEntity
}


//***PERPLEX***V2
//
//package by.vjacheslavkovalenko.asteroidstms.database
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.Query
//import by.vjacheslavkovalenko.asteroidstms.database.entity.PictureOfDayEntity
//
//@Dao
//interface PictureOfDayDao {
//
//    @Insert
//    suspend fun insertPictureOfDay(picture: PictureOfDayEntity)
//
//    @Query("SELECT * FROM PictureOfDay LIMIT 1")
//    suspend fun getPictureOfDay(): PictureOfDayEntity?
//}