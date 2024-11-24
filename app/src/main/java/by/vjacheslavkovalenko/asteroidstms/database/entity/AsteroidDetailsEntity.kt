package by.vjacheslavkovalenko.asteroidstms.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "AsteroidDetails")
data class AsteroidDetailsEntity(
    @PrimaryKey
    @ColumnInfo("asteroidId")
    val asteroidId: String,
    @ColumnInfo("nameAsteroid")
    val nameAsteroid: String,
    @ColumnInfo("estimatedDiameter")
    val estimatedDiameter: List<Double>
)

//заносит в одну "ячейки список (list) через "объединение", а не в "отдельную таблицу"
//первый вариант
fun skmdsnd(list: List<String>) {
    list.joinToString(separator = ",")
}

//второй вариант
fun serializeTypes(list: List<String>): String {
    return list.joinToString(separator = ",")
}
