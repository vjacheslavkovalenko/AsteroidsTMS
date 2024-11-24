package by.vjacheslavkovalenko.asteroidstms.network.entity

import by.vjacheslavkovalenko.asteroidstms.repository.NearEarthObjects
import com.google.gson.annotations.SerializedName

data class ListRadarAsteroidsResponse(

    //количество элементов
    @SerializedName("element_count")
    val elementCount: Int,
//    val links: Links,
    @SerializedName("near_earth_objects")
    val allAsteroidsRadar: by.vjacheslavkovalenko.asteroidstms.network.entity.NearEarthObjects

    //val `2015-09-07`: List<X20150907>,//дата из самого запроса, которую поставил пользователь. Это стартовая дата
    //val `2015-09-08`: List<X20150907>//дата из самого запроса, которую поставил пользователь. Это конечная дата
)
