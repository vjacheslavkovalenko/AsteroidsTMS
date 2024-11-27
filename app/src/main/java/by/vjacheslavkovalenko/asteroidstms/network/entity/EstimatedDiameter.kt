package by.vjacheslavkovalenko.asteroidstms.network.entity

import com.google.gson.annotations.SerializedName

data class EstimatedDiameter(
    @SerializedName("kilometers")
    val kilometers: KilometersDiameter
//    val miles: Miles
)