package by.vjacheslavkovalenko.asteroidstms.network.entity

import com.google.gson.annotations.SerializedName

data class KilometersDiameter(
    @SerializedName("estimated_diameter_max")
    val estimatedDiameterMax: Double,
    @SerializedName("estimated_diameter_min")
    val estimatedDiameterMin: Double
)