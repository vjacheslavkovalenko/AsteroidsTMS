package by.vjacheslavkovalenko.asteroidstms.network.entity

import com.google.gson.annotations.SerializedName

// Класс для представления списка объектов, близких к Земле
data class NearEarthObjects(
    @SerializedName("near_earth_objects")
    val nearEarthObjects: List<NearEarthObject> // Список объектов близких к Земле
)
