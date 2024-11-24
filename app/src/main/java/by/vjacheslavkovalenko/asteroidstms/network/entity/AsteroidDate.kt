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