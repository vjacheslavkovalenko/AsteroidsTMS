package by.vjacheslavkovalenko.asteroidstms.model

import by.vjacheslavkovalenko.asteroidstms.repository.NearEarthObjects
import com.google.gson.annotations.SerializedName

data class AsteroidsRadar (

    //количество элементов
    val elementCount: Int,
   // val allAsteroidsRadar: NearEarthObjects
    val nameAsteroid: String
)