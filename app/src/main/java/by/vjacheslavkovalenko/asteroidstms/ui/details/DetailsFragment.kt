package by.vjacheslavkovalenko.asteroidstms.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentDetailsBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import androidx.fragment.app.Fragment
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import by.vjacheslavkovalenko.asteroidstms.ui.details.domain.DetailsFragmentState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var binding: FragmentDetailsBinding? = null // Привязка будет храниться здесь

    private val viewModel: DetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding?.root ?: throw IllegalStateException("Binding is null")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Получаем идентификатор астероида из аргументов фрагмента (например, из NavArgs)
        val asteroidId = arguments?.getString("ASTEROID_ID") ?: return

        // Загружаем детали астероида
        viewModel.loadAsteroidDetails(asteroidId)

        // Наблюдаем за состоянием ViewModel
        lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                when (state) {
                    is DetailsFragmentState.Init -> {
                        // Инициализация UI, если необходимо
                    }

                    is DetailsFragmentState.DetailsLoaded -> {
                        displayAsteroidDetails(state.asteroid)
                    }

                    is DetailsFragmentState.Error -> {
                        showError(state.message)
                    }
                }
            }
        }
    }

    private fun displayAsteroidDetails(asteroid: Asteroids) {
        binding?.nameTextView?.text = asteroid.name // Используем безопасный вызов
        binding?.diameterTextView?.text =
            "Diameter: ${asteroid.estimatedDiameterMin} - ${asteroid.estimatedDiameterMax} km"
        binding?.hazardousTextView?.text =
            if (asteroid.isPotentiallyHazardous) "Potentially Hazardous" else "Not Hazardous"
    }

    private fun showError(message: String) {
        binding?.errorTextView?.text = message // Предполагается наличие TextView для ошибок
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null // Освобождение привязки при уничтожении представления
    }
}