package by.vjacheslavkovalenko.asteroidstms.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.vjacheslavkovalenko.asteroidstms.domain.Asteroid
import by.vjacheslavkovalenko.asteroidstms.repository.AsteroidRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: AsteroidRepository) : ViewModel() {

    private val asteroidsLiveData = MutableLiveData<List<Asteroid>>() // Убрали знак подчеркивания

    val asteroids: LiveData<List<Asteroid>> get() = asteroidsLiveData // Геттер для LiveData

    fun fetchAsteroids() {
        viewModelScope.launch {
            asteroidsLiveData.value = repository.getAsteroids("2024-01-01", "2024-01-07") // Пример дат.
        }
    }
}