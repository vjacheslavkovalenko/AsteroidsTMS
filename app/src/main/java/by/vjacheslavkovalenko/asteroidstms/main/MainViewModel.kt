package by.vjacheslavkovalenko.asteroidstms.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.vjacheslavkovalenko.asteroidstms.domain.Asteroid
import by.vjacheslavkovalenko.asteroidstms.repository.AsteroidRepository
import by.vjacheslavkovalenko.asteroidstms.utils.DateUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: AsteroidRepository) : ViewModel() {

    private val asteroidsLiveData = MutableLiveData<List<Asteroid>>() // Хранит список астероидов.
    val asteroids: LiveData<List<Asteroid>> get() = asteroidsLiveData // Геттер для LiveData.

    // Метод для получения астероидов.
    fun fetchAsteroids() {
        viewModelScope.launch {
            val startDate = DateUtils.getTodayDate() // Получаем сегодняшнюю дату.
            val endDate = DateUtils.getEndDate() // Получаем дату через 6 дней.
            asteroidsLiveData.value =
                repository.getAsteroids(startDate, endDate) // Получаем астероиды из репозитория.
        }
    }
}