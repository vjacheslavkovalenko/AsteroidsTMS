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

//ии написал
//package by.vjacheslavkovalenko.asteroidstms.network.entity
//
//import com.google.gson.annotations.SerializedName
//
//data class ListRadarAsteroidsResponse(
//
//    // Количество элементов
//    @SerializedName("element_count")
//    val elementCount: Int,
//
//    // Список астероидов, находящихся вблизи Земли
//    @SerializedName("near_earth_objects")
//    val nearEarthObjects: Map<String, List<NearEarthObject>>
//)
//
//// Класс для представления объекта около Земли
//data class NearEarthObject(
//    @SerializedName("id")
//    val asteroidId: String,
//
//    @SerializedName("name")
//    val name: String,
//
//    @SerializedName("estimated_diameter")
//    val estimatedDiameter: EstimatedDiameter,
//
//    @SerializedName("is_potentially_hazardous_asteroid")
//    val isPotentiallyHazardous: Boolean? = null
//)
//
//// Класс для представления оценочного диаметра
//data class EstimatedDiameter(
//    @SerializedName("kilometers")
//    val kilometers: DiameterDetails
//)
//
//data class DiameterDetails(
//    @SerializedName("estimated_diameter_min")
//    val min: Double,
//
//    @SerializedName("estimated_diameter_max")
//    val max: Double
//)