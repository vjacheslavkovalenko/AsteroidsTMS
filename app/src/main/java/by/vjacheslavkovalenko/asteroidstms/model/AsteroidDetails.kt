package by.vjacheslavkovalenko.asteroidstms.model

import by.vjacheslavkovalenko.asteroidstms.network.entity.EstimatedDiameter
import com.google.gson.annotations.SerializedName

data class AsteroidDetails(
    val asteroidId: String,
    val nameAsteroid: String,
    val estimatedDiameter: List<Double>,
)