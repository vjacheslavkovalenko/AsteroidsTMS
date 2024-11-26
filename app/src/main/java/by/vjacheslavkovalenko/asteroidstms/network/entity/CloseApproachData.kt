package by.vjacheslavkovalenko.asteroidstms.network.entity

import com.google.gson.annotations.SerializedName

//Данные о сближении (астероида)
data class CloseApproachData(
    //дата сближения
    @SerializedName("close_approach_date")
    val closeApproachDate: String,
    @SerializedName("close_approach_date_full")
    val closeApproachDateFull: String,
//    Unix-время (англ. Unix time)
    @SerializedName("epoch_date_close_approach")
    val unixTimeDateCloseApproach: Long,
    //val miss_distance: MissDistance,
    //вращается вокруг (тела)
    @SerializedName("orbiting_body")
    val orbitingBody: String,
    //val relative_velocity: RelativeVelocity
)
