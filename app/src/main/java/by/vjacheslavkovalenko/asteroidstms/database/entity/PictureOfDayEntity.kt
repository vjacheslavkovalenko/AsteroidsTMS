package by.vjacheslavkovalenko.asteroidstms.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Нужен ли этот файл?
@Entity(tableName = "Picture")
data class PictureOfDayEntity(
    @PrimaryKey
    @ColumnInfo("title")
    val title: String
)


//***PERPLEX***V2
//
//package by.vjacheslavkovalenko.asteroidstms.database.entity
//
//import androidx.room.Entity
//import androidx.room.PrimaryKey
//
//@Entity(tableName = "PictureOfDay")
//data class PictureOfDayEntity(
//    @PrimaryKey val title: String,
//    val url: String,
//    val explanation: String
//)