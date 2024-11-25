package by.vjacheslavkovalenko.asteroidstms.network.entity

import com.google.gson.annotations.SerializedName

//это класс для списка всех астероидов, чтобы потом вычислить крупнейшие

data class ListAsteroidsResponse(//запрос на все астероиды (список)
//    val links: Links,
//    val near_earth_objects: List<NearEarthObject>,
//    val page: Page

//    val kilometers_per_second: String, //относительная скорость RelativeVelocity
//    val estimated_diameter_max: Double,//оценочный диаметр в км
//    val astronomical: String, // MissDistance( //я так понял, это дистанция в а.е.
//    val absolute_magnitude_h: Double,
//    val id: String,
//    val name: String,
//    val is_potentially_hazardous_asteroid: Boolean,

    //этот параметр удалить, так как взял его для проверки из другой группы (класса Page)
    @SerializedName("total_elements")
    val totalElements: Int,
    @SerializedName("near_earth_objects")
    val allAsteroids: List<AsteroidResponse>,
    // проверяю, сработает ли (так как возникает ошибка в "AsteroidsListRemoteMediator"
    @SerializedName("name")
    val name: String

    //val asteroidParameters : List<AsteroidResponse>

)


//data class ListFeedAsteroids( //это из запроса, который я отправлял по дате (где он находится на конкретную дату)
//    val element_count: Int,
//    val links: by.vjacheslavkovalenko.asteroidstms.repository.Links,
//    val near_earth_objects: NearEarthObjects
//)


//data class RelativeVelocity( //относительная скорость
//    val kilometers_per_second: String,
//)

//data class CloseApproachData( //я так понял, это дата сближения с Землёй (самое близкое расстояние, т.е. дата, когда у астероида самое минимальное расстояние к Земле)
//    val close_approach_date: String,
//    val close_approach_date_full: String,
//    val epoch_date_close_approach: Long,
//    val miss_distance: MissDistance,
//    val orbiting_body: String,
//    val relative_velocity: RelativeVelocity
//)

//data class Kilometers( //оценочный диаметр в км
//    val estimated_diameter_max: Double,
//    val estimated_diameter_min: Double
//)

//data class MissDistance( //я так понял, это дистанция в тех единицах, которые удобнее (хочет пользователь)
//    val astronomical: String,
//    val kilometers: String,
//    val lunar: String,
//    val miles: String
//)

//data class NearEarthObject( //околоземный объект-что они этим хотели сказать?
//    val absolute_magnitude_h: Double,
//    val close_approach_data: List<CloseApproachData>,
//    val designation: String,
//    val estimated_diameter: EstimatedDiameter,
//    val id: String,
//    val is_potentially_hazardous_asteroid: Boolean,
//    val is_sentry_object: Boolean,
//    val links: LinksX,
//    val name: String,
//    val name_limited: String,
//    val nasa_jpl_url: String, //ссылка на страницу НАСА с данными об астероиде
//    val neo_reference_id: String,
//    val orbital_data: OrbitalData
//)

//data class OrbitalData(  //данные орбиты астерода (орбитальные данные)
//    val aphelion_distance: String,
//    val ascending_node_longitude: String,
//    val data_arc_in_days: Int,
//    val eccentricity: String,
//    val epoch_osculation: String,
//    val equinox: String,
//    val first_observation_date: String,
//    val inclination: String,
//    val jupiter_tisserand_invariant: String,
//    val last_observation_date: String,
//    val mean_anomaly: String,
//    val mean_motion: String,
//    val minimum_orbit_intersection: String,
//    val observations_used: Int,
//    val orbit_class: OrbitClass,
//    val orbit_determination_date: String,
//    val orbit_id: String,
//    val orbit_uncertainty: String,
//    val orbital_period: String,
//    val perihelion_argument: String,
//    val perihelion_distance: String,
//    val perihelion_time: String,
//    val semi_major_axis: String
//)

//data class OrbitClass(  // класс астероида (Общая классификация астероидов)
//Астероиды объединяют в группы и семейства на основе характеристик их орбит. Обычно группа получает название по имени первого астероида, который был обнаружен на данной орбите. Группы — относительно свободные образования, тогда как семейства — более плотные, образованные в прошлом при разрушении крупных астероидов от столкновений с другими объектами
//    val orbit_class_description: String,
//    val orbit_class_range: String,
//    val orbit_class_type: String
//)

//data class EstimatedDiameter( // оценочный (расчётный) диаметр астероида, в тех единицах, которые нужны пользователю (хочет пользователь)
//    val feet: Feet,
//    val kilometers: Kilometers,
//    val meters: Meters,
//    val miles: Miles
//)


//data class X20150907(   //это ответ по конкретному астероиду (его номер X20150907)
//нет. как я понял, это дата X20150907
//    val absolute_magnitude_h: Double,
//    val close_approach_data: List<CloseApproachData>,
//    val estimated_diameter: EstimatedDiameter,
//    val id: String,
//    val is_potentially_hazardous_asteroid: Boolean,
//    val is_sentry_object: Boolean,
//    val links: LinksX,
//    val name: String,
//    val nasa_jpl_url: String,
//    val neo_reference_id: String
//)




//ии написал:
//package by.vjacheslavkovalenko.asteroidstms.network.entity
//
//import com.google.gson.annotations.SerializedName
//
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
//data class ListAsteroidsResponse(
//     val totalElements: Int,
//     val nearEarthObjects: List<AsteroidResponse>,
//     val name: String? = null // Опционально
//)