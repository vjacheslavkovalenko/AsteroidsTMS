package by.vjacheslavkovalenko.asteroidstms.model

import by.vjacheslavkovalenko.asteroidstms.network.entity.AsteroidResponse
import by.vjacheslavkovalenko.asteroidstms.network.entity.EstimatedDiameter
import com.google.gson.annotations.SerializedName

data class Asteroids(
    @SerializedName("id")
    val asteroidId: String,
    @SerializedName("name")
    val nameAsteroid: String,
    @SerializedName("estimated_diameter_min")
    val estimatedDiameterMin: Double,
    @SerializedName("estimated_diameter_max")
    val estimatedDiameterMax: Double,
    @SerializedName("is_potentially_hazardous_asteroid")
    val isPotentiallyHazardous: Boolean
)