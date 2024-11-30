package by.vjacheslavkovalenko.asteroidstms.ui.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentDetailsBinding
import kotlinx.coroutines.launch
import androidx.fragment.app.Fragment
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import by.vjacheslavkovalenko.asteroidstms.ui.details.domain.DetailsFragmentState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import by.vjacheslavkovalenko.asteroidstms.model.AsteroidDetails

//555
@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var binding: FragmentDetailsBinding? = null
    private var viewModel: DetailsViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val asteroidId = arguments?.getString("ASTEROID_ID") ?: return // Получаем идентификатор астероида из аргументов

        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        viewModel?.fetchAsteroidDetails(asteroidId)

        viewModel?.state?.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is DetailsFragmentState.Loading -> {
                    // Показать индикатор загрузки
                    binding?.progressBar?.visibility = View.VISIBLE
                }
                is DetailsFragmentState.Success -> {
                    // Скрыть индикатор загрузки и отобразить данные об астероиде
                    binding?.progressBar?.visibility = View.GONE
                    displayAsteroidDetails(state.asteroidDetails)
                }
                is DetailsFragmentState.Error -> {
                    // Скрыть индикатор загрузки и показать сообщение об ошибке
                    binding?.progressBar?.visibility = View.GONE
                    binding?.errorTextView?.text = state.message
                }
            }
        })
    }

    private fun displayAsteroidDetails(asteroidDetails: AsteroidDetails) {
        binding?.textViewAsteroidName?.text = asteroidDetails.nameAsteroid
        binding?.textViewDiameter?.text = "Diameter: ${asteroidDetails.estimatedDiameter} km"
        // Дополнительные поля для отображения...
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null // Освобождаем привязку при уничтожении представления
    }
}

//@AndroidEntryPoint
//class DetailsFragment : Fragment() {
//
//    private var binding: FragmentDetailsBinding? = null
//
//    private val viewModel: DetailsViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentDetailsBinding.inflate(inflater, container, false)
//        // Получите аргументы и отобразите данные астероида здесь.
//        //  val asteroidId = arguments?.getString("asteroidId") // Получите ID астероида из аргументов.
//
//        // Здесь вы можете загрузить данные об астероиде по ID (например, из ViewModel или API).
//        return binding?.root ?: throw IllegalStateException("Binding is null")
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        // Получаем идентификатор астероида из аргументов фрагмента (например, из NavArgs)
//        val asteroidId = arguments?.getString("asteroidId") ?: return
//
//        // Загружаем детали астероида
//        viewModel.loadAsteroidDetails(asteroidId)
//
//        // Наблюдаем за состоянием ViewModel
//        lifecycleScope.launch {
//            viewModel.state.collectLatest { state ->
//                when (state) {
//                    is DetailsFragmentState.Init -> {
//                        // Инициализация UI, если необходимо
//                    }
//
//                    is DetailsFragmentState.DetailsLoaded -> {
//                        displayAsteroidDetails(state.asteroidDetails)
//                    }
//
//                    is DetailsFragmentState.Error -> {
//                        showError(state.message)
//                    }
//                }
//            }
//        }
//    }
//
//    @SuppressLint("SetTextI18n")
//    private fun displayAsteroidDetails(asteroid: Asteroids) {
//        binding?.textViewAsteroidName?.text = asteroid.nameAsteroid // Отображение имени астероида.
//        binding?.textViewDiameter?.text =
//            "Diameter: ${asteroid.estimatedDiameterMin} - ${asteroid.estimatedDiameterMax} km"
//        binding?.textViewHazardous?.text =
//            if (asteroid.isPotentiallyHazardous) "Potentially Hazardous" else "Not Hazardous"
//    }
//
//    private fun showError(message: String) {
//        binding?.errorTextView?.text = message // Предполагается наличие TextView для ошибок
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null
//    }
//}