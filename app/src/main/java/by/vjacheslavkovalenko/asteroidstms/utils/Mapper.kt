package by.vjacheslavkovalenko.asteroidstms.utils

import by.vjacheslavkovalenko.asteroidstms.model.PictureOfDay
import by.vjacheslavkovalenko.asteroidstms.network.entity.PictureOfDayResponse

// это неправильный файл, т.к. потоки надо засовывать во flow (или репозиторий или Use Case)
fun PictureOfDayResponse.toPictureOfDay() = PictureOfDay(url)

//fun ListBreedsResponse.toListBreed(): List<Breed> {
//    val list = arrayListOf<Breed>()
//    this.message.forEach { (name, listSubBread) ->
//        list.add(
//            Breed(
//                name = name,
//                subBreed = listSubBread
//            )
//        )
//    }
//    return list
//}