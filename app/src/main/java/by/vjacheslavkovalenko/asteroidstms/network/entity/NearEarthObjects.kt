package by.vjacheslavkovalenko.asteroidstms.network.entity

data class NearEarthObjects(

    val firstDate : List<AsteroidDate>,
    val secondDate : List<AsteroidDate>

//    val startDate : String = LocalDate.now().toDate().convertDateToString(),
//    val endDate : String = LocalDate.now().plusDays(6).toDate().convertDateToString()


//    val `2015-09-07`: List<X20150907>,//дата из самого запроса, которую поставил пользователь. Это стартовая дата
//    val `2015-09-08`: List<X20150907>//дата из самого запроса, которую поставил пользователь. Это конечная дата
//то есть, тут распихивают по датам астероиды
)
