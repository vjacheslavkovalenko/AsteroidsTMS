package by.vjacheslavkovalenko.asteroidstms.model

import by.vjacheslavkovalenko.asteroidstms.network.entity.AsteroidResponse
import by.vjacheslavkovalenko.asteroidstms.network.entity.EstimatedDiameter
import com.google.gson.annotations.SerializedName

data class Asteroids(
    //этот параметр удалить, так как взял его для проверки из другой группы (класса Page)
    //val totalElements: Int,
    //val allAsteroids : List<AsteroidResponse>,
    @SerializedName("id")
    val asteroidId: String,
    //  val nameAsteroid: String,
    // val estimatedDiameter: List<Double>

    @SerializedName("name")
    val nameAsteroid: String,
    @SerializedName("estimated_diameter_min")
    val estimatedDiameterMin: Double,
    @SerializedName("estimated_diameter_max")
    val estimatedDiameterMax: Double,
    @SerializedName("is_potentially_hazardous_asteroid")
    val isPotentiallyHazardous: Boolean
)

//***PERPLEX***
//
//package by.vjacheslavkovalenko.asteroidstms.model
//
//data class Asteroids(
//    val asteroidId: String,
//    val name: String,
//    val estimatedDiameterMin: Double,
//    val estimatedDiameterMax: Double,
//    val isPotentiallyHazardous: Boolean
//)