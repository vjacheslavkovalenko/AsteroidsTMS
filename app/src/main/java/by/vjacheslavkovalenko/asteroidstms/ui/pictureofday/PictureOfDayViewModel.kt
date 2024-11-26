package by.vjacheslavkovalenko.asteroidstms.ui.pictureofday

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import by.vjacheslavkovalenko.asteroidstms.domain.LoadAsteroidsListUseCase
import by.vjacheslavkovalenko.asteroidstms.domain.LoadPictureOfDayUseCase
import by.vjacheslavkovalenko.asteroidstms.ui.list.domain.ListFragmentState
import by.vjacheslavkovalenko.asteroidstms.ui.pictureofday.domain.PictureFragmentState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PictureOfDayViewModel @Inject constructor(
    private val loadPictureOfDayUseCase: LoadPictureOfDayUseCase
) : ViewModel() {

    private val stateFlow = MutableStateFlow<PictureFragmentState>(PictureFragmentState.Init)
    val state: StateFlow<PictureFragmentState> get() = stateFlow

    // Функция для загрузки картинки дня
    fun loadPicture() {
        viewModelScope.launch {
            try {
                val result =
                    loadPictureOfDayUseCase.loadPictureOfDay("title") // Укажите нужный заголовок или используйте API для получения заголовка.
                stateFlow.emit(PictureFragmentState.PictureLoaded(result))
            } catch (e: Exception) {
                stateFlow.emit(PictureFragmentState.Error(e.message ?: "Unknown error"))
            }
        }
    }
}