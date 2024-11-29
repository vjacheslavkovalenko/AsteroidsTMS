package by.vjacheslavkovalenko.asteroidstms.network.entity

import com.google.gson.annotations.SerializedName

//Характеристики (параметры) объекта около Земли
data class NearEarthObject(
    @SerializedName("id")
    val asteroidId: String,
    @SerializedName("name")
    val nameAsteroid: String,
    @SerializedName("absolute_magnitude_h")
    val absoluteMagnitude: Double,
    @SerializedName("estimated_diameter")
    val estimatedDiameter: EstimatedDiameter,
    @SerializedName("is_potentially_hazardous_asteroid")
    val isPotentiallyHazardous: Boolean,
)