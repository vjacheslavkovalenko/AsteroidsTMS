package by.vjacheslavkovalenko.asteroidstms.network.entity

import com.google.gson.annotations.SerializedName

//Оценочный диаметр в км, для диаметра
data class Kilometers(
    @SerializedName("estimated_diameter_max")
    val estimatedDiameterMax: Double,
    @SerializedName("estimated_diameter_min")
    val estimatedDiameterMin: Double
)