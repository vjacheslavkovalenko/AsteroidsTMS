package by.vjacheslavkovalenko.asteroidstms.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Asteroids")
data class AsteroidsEntity(
    @PrimaryKey
    @ColumnInfo("asteroidId")
    val asteroidId: String,
    val name: String,
    val estimatedDiameterMin: Double,
    val estimatedDiameterMax: Double,
    val isPotentiallyHazardous: Boolean
)

//data class NearEarthObject(
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
//    val nasa_jpl_url: String,
//    val neo_reference_id: String,
//    val orbital_data: OrbitalData

//    val estimated_diameter_max: Double,
//    val estimated_diameter_min: Double


//@SerializedName("estimated_diameter")
//val estimatedDiameter: EstimatedDiameter

//***PERPLEX***
//
//data class AsteroidsEntity(
//    @PrimaryKey val asteroidId: String,
//    val name: String,
//    val estimatedDiameterMin: Double,
//    val estimatedDiameterMax: Double,
//    val isPotentiallyHazardous: Boolean,
//)