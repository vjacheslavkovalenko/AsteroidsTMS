package by.vjacheslavkovalenko.asteroidstms.model

import by.vjacheslavkovalenko.asteroidstms.network.entity.AsteroidResponse
import com.google.gson.annotations.SerializedName

data class Asteroids(
    //этот параметр удалить, так как взял его для проверки из другой группы (класса Page)
    val totalElements: Int,
    //val allAsteroids : List<AsteroidResponse>,
    val asteroidId: String,
  //  val nameAsteroid: String,
   // val estimatedDiameter: List<Double>
)