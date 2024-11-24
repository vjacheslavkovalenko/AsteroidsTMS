package by.vjacheslavkovalenko.asteroidstms.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Asteroids")
data class AsteroidsEntity (
    @PrimaryKey
    @ColumnInfo("asteroidId")
    val asteroidId: String,
    //этот параметр удалить, так как взял его для проверки из другой группы (класса Page)
    //@ColumnInfo("totalElements")
   // val totalElements: Int
    //он не работает: выдает ошибку, что не находит значения

)