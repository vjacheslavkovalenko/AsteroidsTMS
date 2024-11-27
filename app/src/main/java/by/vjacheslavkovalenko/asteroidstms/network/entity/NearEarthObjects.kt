package by.vjacheslavkovalenko.asteroidstms.network.entity

data class NearEarthObjects(

    val firstDate: List<AsteroidDate>,
    val secondDate: List<AsteroidDate>

//    val startDate : String = LocalDate.now().toDate().convertDateToString(),
//    val endDate : String = LocalDate.now().plusDays(6).toDate().convertDateToString()
)