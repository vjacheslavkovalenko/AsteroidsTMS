package by.vjacheslavkovalenko.asteroidstms.network.entity

import com.google.gson.annotations.SerializedName

data class ListRadarAsteroidsResponse(
    //количество элементов в ответе API
    @SerializedName("element_count")
    val elementCount: Int,
    // Список объектов близких к Земле
    @SerializedName("near_earth_objects")
    val nearEarthObjects: Map<String, List<NearEarthObject>>
)