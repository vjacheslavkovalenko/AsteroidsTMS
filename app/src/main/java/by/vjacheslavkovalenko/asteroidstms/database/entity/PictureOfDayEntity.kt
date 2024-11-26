package by.vjacheslavkovalenko.asteroidstms.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "PictureOfDay")
data class PictureOfDayEntity(
    @PrimaryKey
    @ColumnInfo("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("explanation")
    val explanation: String
)

//***PERPLEX***V2
//
//@Entity(tableName = "PictureOfDay")
//data class PictureOfDayEntity(
//    @PrimaryKey val title: String,
//    val url: String,
//    val explanation: String
//)