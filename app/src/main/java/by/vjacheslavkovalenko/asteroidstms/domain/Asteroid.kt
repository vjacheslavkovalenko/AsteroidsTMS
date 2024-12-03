package by.vjacheslavkovalenko.asteroidstms.domain

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcel

@Parcelize
@Entity(tableName = "asteroid_table")
data class Asteroid(
    @PrimaryKey
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val codename: String,
    @SerializedName("close_approach_date")
    val closeApproachDate: String,
    @SerializedName("absolute_magnitude_h")
    val absoluteMagnitude: Double,
    @SerializedName("estimated_diameter_max")
    val estimatedDiameter: Double,
    @SerializedName("kilometers_per_second")
    val relativeVelocity: Double,
    @SerializedName("astronomical")
    val distanceFromEarth: Double,
    @SerializedName("is_potentially_hazardous_asteroid")
    val isPotentiallyHazardous: Boolean
): Parcelable