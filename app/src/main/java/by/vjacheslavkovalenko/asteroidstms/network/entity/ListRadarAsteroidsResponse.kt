package by.vjacheslavkovalenko.asteroidstms.network.entity


import com.google.gson.annotations.SerializedName

data class ListRadarAsteroidsResponse(
    //количество элементов
    @SerializedName("element_count")
    val elementCount: Int,
    @SerializedName("near_earth_objects")
    val nearEarthObjects: Map<String, List<NearEarthObject>>
//    val allAsteroidsRadar: by.vjacheslavkovalenko.asteroidstms.network.entity.NearEarthObjects

    //val `2015-09-07`: List<X20150907>,//дата из самого запроса, которую поставил пользователь. Это стартовая дата
    //val `2015-09-08`: List<X20150907>//дата из самого запроса, которую поставил пользователь. Это конечная дата
)


//***PERPLEX***V5
//
//
//package by.vjacheslavkovalenko.asteroidstms.network.entity
//
//data class ListRadarAsteroidsResponse(
//    val element_count: Int,
//    val near_earth_objects: Map<String, List<NearEarthObject>>
//)
//
//data class NearEarthObject(
//    val id: String,
//    val neo_reference_id: String,
//    val name: String,
//    val nasa_jpl_url: String,
//    val absolute_magnitude_h: Double,
//    val estimated_diameter: EstimatedDiameter,
//    val is_potentially_hazardous_asteroid: Boolean
//)
//
//data class EstimatedDiameter(
//    val kilometers: DiameterRange
//)
//
//data class DiameterRange(
//    val estimated_diameter_min: Double,
//    val estimated_diameter_max: Double
//)