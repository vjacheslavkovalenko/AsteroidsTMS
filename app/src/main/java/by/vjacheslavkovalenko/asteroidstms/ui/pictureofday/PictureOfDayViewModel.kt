package by.vjacheslavkovalenko.asteroidstms.ui.pictureofday

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.vjacheslavkovalenko.asteroidstms.domain.LoadPictureOfDayUseCase
import by.vjacheslavkovalenko.asteroidstms.ui.pictureofday.domain.PictureFragmentState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlinx.coroutines.flow.collectLatest

@HiltViewModel
class PictureOfDayViewModel @Inject constructor(
    private val loadPictureOfDayUseCase: LoadPictureOfDayUseCase
) : ViewModel() {

    val state = MutableStateFlow<PictureFragmentState>(PictureFragmentState.Loading)

    fun fetchPictureOfDay() {
        state.value = PictureFragmentState.Loading // Устанавливаем состояние загрузки

        viewModelScope.launch {
            try {
                // Загружаем данные о картине дня через use case
                val picture = loadPictureOfDayUseCase()

                // Проверяем, что picture не равно null перед доступом к его свойствам
                if (picture != null) {
                    state.value = PictureFragmentState.Success(
                        picture = picture // Передаем объект PictureOfDayEntity в состояние Success
                    )
                } else {
                    state.value = PictureFragmentState.Error("No picture available")
                }
            } catch (e: Exception) {
                // В случае ошибки обновляем состояние на ошибочное с сообщением об ошибке
                state.value = PictureFragmentState.Error(e.message ?: "Unknown error")
            }
        }
    }
}
//555
//
//
//Объяснение кода
//Импорт необходимых классов:
//Импортируются классы для работы с ViewModel, корутинами и состоянием.
//Класс PictureOfDayViewModel:
//Аннотирован с помощью @HiltViewModel, что позволяет использовать внедрение зависимостей через Dagger Hilt.
//Принимает LoadPictureOfDayUseCase в качестве зависимости, чтобы загружать данные о картине дня.
//Состояние:
//Используется MutableStateFlow для хранения текущего состояния фрагмента, которое может быть загрузкой, успешным получением данных или ошибкой.
//Метод fetchPictureOfDay:
//Устанавливает состояние в Loading перед началом загрузки.
//Запускает корутину для асинхронной загрузки данных.
//В случае успешной загрузки обновляет состояние на Success, передавая URL, заголовок и объяснение картины дня.
//В случае ошибки обновляет состояние на Error, передавая сообщение об ошибке.
//Заключение
//Теперь у вас есть полностью реализованный класс PictureOfDayViewModel, который управляет состоянием и загрузкой данных о картине дня. Этот класс можно использовать во View для отображения информации о картине дня и обработки различных состояний пользовательского интерфейса.