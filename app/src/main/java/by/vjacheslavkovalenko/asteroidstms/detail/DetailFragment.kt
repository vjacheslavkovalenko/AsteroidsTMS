package by.vjacheslavkovalenko.asteroidstms.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentDetailBinding

@AndroidEntryPoint // Аннотация для поддержки Hilt.
class DetailFragment : Fragment() {

    private var binding: FragmentDetailBinding? = null // Привязка данных для фрагмента
    private val viewModel: DetailViewModel by viewModels() // Использование ViewModel с Hilt

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Получение данных астероида, переданных из MainFragment.
        val args: DetailFragmentArgs by navArgs()
        viewModel.setAsteroid(args.selectedAsteroid) // Установка астероида в ViewModel

        // Привязка данных к интерфейсу (если используете Data Binding)
        binding?.asteroid = viewModel.asteroid.value
        binding?.executePendingBindings() // Обновление привязки данных
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null // Освобождение ссылки при уничтожении фрагмента
    }
}