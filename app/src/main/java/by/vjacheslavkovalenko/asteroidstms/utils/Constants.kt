package by.vjacheslavkovalenko.asteroidstms.utils

object Constants {
    const val BASEURL = "https://api.nasa.gov/"
    const val APIKEY = "gM0Ze05VWVs9uAcahDClWEvapDNv7m5MNiuO3TLl"
    //    const val PICTURE_OF_DAY_ENDPOINT = "apod?api_key=$API_KEY"
//    const val ASTEROIDS_ENDPOINT = "neo/rest/v1/neo/browse?api_key=$API_KEY"
}

//Объяснение кода
//BASE_URL: Константа, содержащая базовый URL для доступа к NASA API. Это основной адрес, к которому будут добавляться конечные точки.
//API_KEY: Константа для хранения ключа API, который необходим для выполнения запросов к API. Замените "YOUR_API_KEY" на ваш фактический ключ.
//PICTURE_OF_DAY_ENDPOINT: Константа, представляющая конечную точку для получения картины дня с использованием ключа API.
//ASTEROIDS_ENDPOINT: Константа, представляющая конечную точку для получения данных об астероидах с использованием ключа API.
//Этот класс позволяет централизовать все константы, связанные с конфигурацией приложения, что упрощает их использование и изменение в будущем.