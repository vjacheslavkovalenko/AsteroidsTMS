package by.vjacheslavkovalenko.asteroidstms.ui.pictureofday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.vjacheslavkovalenko.asteroidstms.database.entity.PictureOfDayEntity
import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentPictureOfDayBinding
import by.vjacheslavkovalenko.asteroidstms.ui.pictureofday.domain.PictureFragmentState
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

//555
@AndroidEntryPoint
class PictureOfDayFragment : Fragment() {

    private var binding: FragmentPictureOfDayBinding? = null
    private val viewModel: PictureOfDayViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPictureOfDayBinding.inflate(inflater, container, false)
        return binding?.root ?: throw IllegalStateException("Binding is null")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                when (state) {
                    is PictureFragmentState.Loading -> {
                        // Здесь можно показать индикатор загрузки, если необходимо
                    }
                    is PictureFragmentState.Success -> {
                        displayPicture(state.picture)
                    }
                    is PictureFragmentState.Error -> {
                        showError(state.message)
                    }
                }
            }
        }

        // Загружаем картинку дня при создании фрагмента
        viewModel.fetchPictureOfDay()
    }

    private fun displayPicture(picture: PictureOfDayEntity) {
        binding?.imageViewPictureOfDayDetail?.let { imageView ->
            Glide.with(this).load(picture.url)
                .into(imageView) // Используем библиотеку Glide для загрузки изображений
        }
        binding?.textViewDescription?.text = picture.explanation // Устанавливаем описание картинки
    }

    private fun showError(message: String) {
        binding?.errorTextView?.text = message // Предполагается наличие TextView для отображения ошибок
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null // Очищаем привязку при уничтожении представления
    }
}
//
//Объяснение кода
//Импорт необходимых классов:
//Импортируются классы для работы с фрагментами, ViewModel, корутинами и библиотекой Glide.
//Класс PictureOfDayFragment:
//Аннотирован с помощью @AndroidEntryPoint, что позволяет использовать внедрение зависимостей через Dagger Hilt.
//Использует FragmentPictureOfDayBinding для привязки пользовательского интерфейса.
//Метод onCreateView:
//Инициализирует привязку и возвращает корневое представление.
//Метод onViewCreated:
//Подписывается на состояние ViewModel и обновляет пользовательский интерфейс в зависимости от состояния (загрузка, успех или ошибка).
//Вызывает метод fetchPictureOfDay() для загрузки данных о картине дня.
//Метод displayPicture:
//Использует библиотеку Glide для загрузки изображения из URL в ImageView.
//Устанавливает текст описания картинки.
//Метод showError:
//Отображает сообщение об ошибке в TextView.
//Метод onDestroyView:
//Очищает привязку при уничтожении представления, чтобы избежать утечек памяти.
//Заключение
//Теперь у вас есть полностью реализованный класс PictureOfDayFragment, который управляет отображением картины дня в пользовательском интерфейсе и взаимодействует с ViewModel для загрузки данных.
//