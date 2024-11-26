package by.vjacheslavkovalenko.asteroidstms.network.entity


import com.google.gson.annotations.SerializedName

data class ListRadarAsteroidsResponse(
    //количество элементов
    @SerializedName("element_count")
    val elementCount: Int,
    @SerializedName("near_earth_objects")
    val nearEarthObjects: Map<String, List<NearEarthObject>>
)