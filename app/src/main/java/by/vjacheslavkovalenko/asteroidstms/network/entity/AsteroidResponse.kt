package by.vjacheslavkovalenko.asteroidstms.network.entity

import com.google.gson.annotations.SerializedName

//Характеристики (параметры) объекта около Земли

//Может, этот класс использовать как NearEarthObject( вместо него), т.е. тут параметры одного астероида
data class AsteroidResponse(
    //val kilometers_per_second: String, //относительная скорость RelativeVelocity
    //@SerializedName("estimated_diameter_max")
    //val maxDiameterEstimated: Double,//оценочный диаметр в км
    //val astronomical: String, // MissDistance( //я так понял, это дистанция в а.е.
    //val absolute_magnitude_h: Double,
    @SerializedName("id")
    val asteroidId: String,
    @SerializedName("name")
    val nameAsteroid: String,
    @SerializedName("estimated_diameter")
    val estimatedDiameter: EstimatedDiameter
   // val is_potentially_hazardous_asteroid: Boolean,


)

//data class ListAsteroidsResponse( //запрос по дате
//    val links: Links,
//    val near_earth_objects: List<NearEarthObject>,
//    val page: Page


//data class NearEarthObject(
//    val estimated_diameter: EstimatedDiameter,
//)

//data class EstimatedDiameter( // оценочный (расчётный) диаметр астероида, в тех единицах, которые нужны пользователю (хочет пользователь)
//    val feet: Feet,
//    val kilometers: Kilometers,
//    val meters: Meters,
//    val miles: Miles
//)

//data class Kilometers( //оценочный диаметр в км
//    val estimated_diameter_max: Double,
//    val estimated_diameter_min: Double
//)



//ии написал:
//package by.vjacheslavkovalenko.asteroidstms.network.entity
//
//import com.google.gson.annotations.SerializedName
//
//// Характеристики (параметры) объекта около Земли
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
//    // Добавьте другие поля, если необходимо
//    // Например, относительная скорость или дистанция
//    @SerializedName("is_potentially_hazardous_asteroid")
//    val isPotentiallyHazardous: Boolean? = null // Опционально, если нужно
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

//***PERPLEX***
//
//package by.vjacheslavkovalenko.asteroidstms.network.entity
//
//data class AsteroidResponse(
//     val asteroidId: String,
//     val nameAsteroid: String,
//     val estimatedDiameter: EstimatedDiameter,
//     val isPotentiallyHazardous: Boolean? = null // Опционально
//)
//
//data class EstimatedDiameter(
//     val kilometers: DiameterDetails
//)
//
//data class DiameterDetails(
//     val min: Double,
//     val max: Double
//)