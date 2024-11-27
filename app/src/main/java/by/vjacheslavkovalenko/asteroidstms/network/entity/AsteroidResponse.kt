package by.vjacheslavkovalenko.asteroidstms.network.entity

import com.google.gson.annotations.SerializedName

data class AsteroidResponse(
    @SerializedName("id")
    val asteroidId: String,
    @SerializedName("name")
    val nameAsteroid: String,
    @SerializedName("estimated_diameter")
    val estimatedDiameter: EstimatedDiameter,
    @SerializedName("is_potentially_hazardous_asteroid")
    val isPotentiallyHazardous: Boolean
)