package by.vjacheslavkovalenko.asteroidstms.network.entity

import com.google.gson.annotations.SerializedName

//это класс для списка всех астероидов, чтобы потом вычислить крупнейшие

data class ListAsteroidsResponse(//запрос на все астероиды (список)
    @SerializedName("total_elements")
    val totalElements: Int,
    @SerializedName("near_earth_objects")
//    val allAsteroids: List<AsteroidResponse>,
    val nearEarthObjects: List<AsteroidResponse>,
    @SerializedName("name")
    val name: String? = null

)