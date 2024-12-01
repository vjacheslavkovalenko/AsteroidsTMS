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
import by.vjacheslavkovalenko.asteroidstms.domain.LoadPictureOfDayUseCase
import dagger.hilt.android.AndroidEntryPoint

//555
@AndroidEntryPoint
class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private val loadPictureOfDayUseCase: LoadPictureOfDayUseCase by viewModels()

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
            // Например, открыть новый фрагмент с информацией.
        }

        //пробую по клику на фото открыть новое окно (с ним и описанием)
        binding?.imageViewPictureOfDay?.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_pictureOfDayFragment)
        }

        // Загрузка картинки дня в ImageView с помощью Glide
        loadPictureOfDay()
    }


    private fun loadPictureOfDay() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            try {
                val pictureOfDay = loadPictureOfDayUseCase() // Получаем картину дня

                if (pictureOfDay != null) {
                    Glide.with(this@MainFragment)
                        .load(pictureOfDay.url) // Замените на правильное свойство URL
                        .into(binding?.imageViewPictureOfDay!!)
                } else {
                    // Установка изображения-заполнителя, если данных нет
                    binding?.imageViewPictureOfDay?.setImageResource(R.drawable.placeholder_image)
                }
            } catch (e: Exception) {
                // Обработка ошибок загрузки изображения
                binding?.imageViewPictureOfDay?.setImageResource(R.drawable.error_image)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

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
