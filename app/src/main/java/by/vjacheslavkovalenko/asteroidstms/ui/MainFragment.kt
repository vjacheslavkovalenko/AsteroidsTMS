package by.vjacheslavkovalenko.asteroidstms.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.vjacheslavkovalenko.asteroidstms.R
import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentMainBinding
import com.bumptech.glide.Glide
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.vjacheslavkovalenko.asteroidstms.domain.LoadPictureOfDayUseCase
import dagger.hilt.android.AndroidEntryPoint
import by.vjacheslavkovalenko.asteroidstms.database.entity.PictureOfDayEntity
import by.vjacheslavkovalenko.asteroidstms.ui.pictureofday.PictureOfDayViewModel
import by.vjacheslavkovalenko.asteroidstms.ui.pictureofday.domain.PictureFragmentState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private val viewModel: PictureOfDayViewModel by viewModels() // Предполагается, что у вас есть MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root ?: throw IllegalStateException("Binding is null")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Подписка на состояние ViewModel
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

        // Обработка нажатия на кнопку "О приложении"
        binding?.buttonAboutApp?.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_aboutAppFragment)
        }

        // Обработка нажатия на кнопку "Радар астероидов"
        binding?.buttonRadarAsteroids?.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_listFragment)
        }

        // Обработка нажатия на кнопку "Что такое астероиды?"
        binding?.buttonWhatAreAsteroids?.setOnClickListener {
            // Здесь можно добавить логику для отображения информации о астероидах.
        }

        // Обработка нажатия на картинку дня
        binding?.imageViewPictureOfDay?.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_pictureOfDayFragment)
        }
    }

    private fun displayPicture(picture: PictureOfDayEntity) {
        binding?.imageViewPictureOfDay?.let { imageView ->
            Glide.with(this).load(picture.url)
                .into(imageView) // Используем библиотеку Glide для загрузки изображений
        }
    }

    private fun showError(message: String) {
        binding?.errorTextViewImage?.text = message // Предполагается наличие TextView для отображения ошибок
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null // Очищаем привязку при уничтожении представления
    }
}

//           } catch (e: Exception) {
//                // Обработка ошибок загрузки изображения
//                binding?.imageViewPictureOfDay?.setImageResource(R.drawable.none_image)
//            }
//        }
//555


//Объяснение кода MainFragment
//Импорт необходимых классов:
//Импортируются классы для работы с фрагментами, навигацией, привязкой пользовательского интерфейса и библиотекой Glide.
//Класс MainFragment:
//Этот класс представляет главный экран приложения и наследуется от Fragment.
//Переменная binding:
//Используется для привязки элементов пользовательского интерфейса из XML-файла разметки.
//Метод onCreateView:
//Инициализирует привязку и возвращает корневое представление фрагмента.
//Метод onViewCreated:
//Устанавливает обработчики кликов для кнопок и вызывает метод loadPictureOfDay() для загрузки картинки дня.
//Метод loadPictureOfDay:
//Загружает данные о картине дня через UseCase.
//Использует Glide для отображения изображения в ImageView.
//Обрабатывает случаи отсутствия данных и ошибки.
//Метод onDestroyView:
//Очищает привязку при уничтожении представления, чтобы избежать утечек памяти.
//Заключение
//Теперь у вас есть полностью реализованные классы LoadPictureOfDayUseCase и MainFragment, которые обеспечивают функциональность загрузки и отображения картинки дня на главном экране вашего приложения.
