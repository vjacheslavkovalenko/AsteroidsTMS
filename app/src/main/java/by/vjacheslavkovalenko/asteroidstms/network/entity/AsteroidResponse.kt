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