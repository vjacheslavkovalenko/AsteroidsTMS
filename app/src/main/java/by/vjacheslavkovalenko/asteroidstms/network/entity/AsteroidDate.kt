package by.vjacheslavkovalenko.asteroidstms.network.entity

import com.google.gson.annotations.SerializedName

//это файл, который типа "X20210907"
data class AsteroidDate(

//    val absolute_magnitude_h: Double,
//    val close_approach_data: List<CloseApproachData>,
//    val estimated_diameter: EstimatedDiameter,
//    val id: String,
//    val is_potentially_hazardous_asteroid: Boolean,
//    val is_sentry_object: Boolean,
//    val links: LinksX,
//    val name: String,
//    val nasa_jpl_url: String,
//    val neo_reference_id: String,
//    val sentry_data: String
    val formAsteroidResponse : List<AsteroidResponse>
//Может ,оформить типа List<AsteroidResponce>, а ниже (далее) добавить параметры, которых не хватает?

)


//ии написал:
//package by.vjacheslavkovalenko.asteroidstms.network.entity
//
//import com.google.gson.annotations.SerializedName
//
//// Класс для представления списка астероидов, связанных с определенной датой
//data class AsteroidDate(
//    @SerializedName("near_earth_objects")
//    val nearEarthObjects: List<AsteroidResponse>
//)
//
//// Класс для представления ответа об астероиде
//data class AsteroidResponse(
//    @SerializedName("id")
//    val asteroidId: String,
//
//    @SerializedName("name")
//    val nameAsteroid: String,
//
//    @SerializedName("estimated_diameter")
//    val estimatedDiameter: EstimatedDiameter,
//
//    @SerializedName("is_potentially_hazardous_asteroid")
//    val isPotentiallyHazardous: Boolean? = null
//)
//
//// Класс для представления оценочного диаметра астероида
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