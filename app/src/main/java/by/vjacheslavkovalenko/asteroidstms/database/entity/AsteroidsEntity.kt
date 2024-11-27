package by.vjacheslavkovalenko.asteroidstms.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Asteroids")
data class AsteroidsEntity(
    @PrimaryKey
    @ColumnInfo("asteroidId")
    val asteroidId: String,
    val name: String,
    val estimatedDiameterMin: Double,
    val estimatedDiameterMax: Double,
    val isPotentiallyHazardous: Boolean
)