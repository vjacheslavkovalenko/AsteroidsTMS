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