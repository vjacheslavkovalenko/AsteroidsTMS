package by.vjacheslavkovalenko.asteroidstms.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import by.vjacheslavkovalenko.asteroidstms.domain.Asteroid

@HiltViewModel // Аннотация для поддержки Hilt
class DetailViewModel @Inject constructor() : ViewModel() {

    private val asteroidLiveData = MutableLiveData<Asteroid>() // Хранит данные об астероиде
    val asteroid: LiveData<Asteroid> get() = asteroidLiveData // Геттер для LiveData

    // Метод для установки астероида
    fun setAsteroid(selectedAsteroid: Asteroid) {
        asteroidLiveData.value = selectedAsteroid
    }
}