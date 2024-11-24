package by.vjacheslavkovalenko.asteroidstms.network.entity

import com.google.gson.annotations.SerializedName

// оценочный (расчётный) диаметр астероида, в тех единицах, которые нужны пользователю
data class EstimatedDiameter(
//    val feet: Feet,
    @SerializedName("kilometers")
    val kilometers: List<Kilometers>
//    val meters: Meters,
//    val miles: Miles
)