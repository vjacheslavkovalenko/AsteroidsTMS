package by.vjacheslavkovalenko.asteroidstms.ui.details

class DetailsFragment {
}


//ии написал
//package by.vjacheslavkovalenko.asteroidstms.ui.details
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
//import androidx.lifecycle.lifecycleScope
//import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentDetailsBinding
//import dagger.hilt.android.AndroidEntryPoint
//import kotlinx.coroutines.flow.collectLatest
//import kotlinx.coroutines.launch
//
//@AndroidEntryPoint
//class DetailsFragment : Fragment() {
//
//    private var _binding: FragmentDetailsBinding? = null
//    private val binding get() = _binding!!
//
//    private val viewModel: DetailsViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        // Получаем идентификатор астероида из аргументов фрагмента (например, из NavArgs)
//        val asteroidId = arguments?.getString("ASTEROID_ID") ?: return
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
//                    is DetailsFragmentState.DetailsLoaded -> {
//                        displayAsteroidDetails(state.asteroid)
//                    }
//                    is DetailsFragmentState.Error -> {
//                        showError(state.message)
//                    }
//                }
//            }
//        }
//    }
//
//    private fun displayAsteroidDetails(asteroid: Asteroids) {
//        // Здесь вы можете обновить UI с информацией об астероиде
//        binding.nameTextView.text = asteroid.name // Предполагается, что у Asteroids есть поле name
//        binding.diameterTextView.text = "Diameter: ${asteroid.estimatedDiameterMin} - ${asteroid.estimatedDiameterMax} km"
//        binding.hazardousTextView.text = if (asteroid.isPotentiallyHazardous) "Potentially Hazardous" else "Not Hazardous"
//    }
//
//    private fun showError(message: String) {
//        // Обработка ошибки, например, показать Toast или Snackbar
//        binding.errorTextView.text = message // Предполагается, что есть TextView для отображения ошибок
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null // Освобождение привязки при уничтожении представления
//    }
//}




//***PERPLEX***
//
//package by.vjacheslavkovalenko.asteroidstms.ui.details
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
// import androidx.lifecycle.lifecycleScope
// import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentDetailsBinding
// import dagger.hilt.android.AndroidEntryPoint
// import kotlinx.coroutines.flow.collectLatest
// import kotlinx.coroutines.launch
//
//@AndroidEntryPoint
//class DetailsFragment : Fragment() {
//
//     private var _binding: FragmentDetailsBinding? = null
//     private val binding get() = _binding!!
//
//     private val viewModel: DetailsViewModel by viewModels()
//
//     override fun onCreateView(
//         inflater: LayoutInflater,
//         container: ViewGroup?,
//         savedInstanceState: Bundle?
//     ): View {
//         _binding = FragmentDetailsBinding.inflate(inflater, container, false)
//         return binding.root
//     }
//
//     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//         super.onViewCreated(view, savedInstanceState)
//
//         // Получаем идентификатор астероида из аргументов фрагмента (например, из NavArgs)
//         val asteroidId = arguments?.getString("ASTEROID_ID") ?: return
//
//         // Загружаем детали астероида
//         viewModel.loadAsteroidDetails(asteroidId)
//
//         // Наблюдаем за состоянием ViewModel
//         lifecycleScope.launch {
//             viewModel.state.collectLatest { state ->
//                 when (state) {
//                     is DetailsFragmentState.Init -> {}
//                     is DetailsFragmentState.DetailsLoaded -> {
//                         displayAsteroidDetails(state.asteroid)
//                     }
//                     is DetailsFragmentState.Error -> {
//                         showError(state.message)
//                     }
//                 }
//             }
//         }
//     }
//
//     private fun displayAsteroidDetails(asteroid: Asteroids) {
//         binding.nameTextView.text = asteroid.name
//         binding.diameterTextView.text = "Diameter: ${asteroid.estimatedDiameterMin} - ${asteroid.estimatedDiameterMax} km"
//         binding.hazardousTextView.text = if (asteroid.isPotentiallyHazardous) "Potentially Hazardous" else "Not Hazardous"
//     }
//
//     private fun showError(message: String) {
//         binding.errorTextView.text = message // Предполагается наличие TextView для ошибок
//     }
//
//     override fun onDestroyView() {
//         super.onDestroyView()
//         _binding = null // Освобождение привязки при уничтожении представления
//     }
//}




//***PERPLEX***V3---попросил заменить private val binding get() = _binding!!
//
//Мне не нравится эта строка: private val binding get() = _binding!!
//Замени ее на что-то другое, чтобы нигде не было символа _
//Ответ:
//Конечно! Чтобы избежать использования символа подчеркивания (_) в имени переменной, мы можем изменить подход к привязке. Вместо использования приватного свойства _binding, мы можем использовать только одно свойство binding, которое будет инициализироваться в методе onCreateView и очищаться в методе onDestroyView.
//
//
//package by.vjacheslavkovalenko.asteroidstms.ui.details
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
//import androidx.lifecycle.lifecycleScope
//import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentDetailsBinding
//import dagger.hilt.android.AndroidEntryPoint
//import kotlinx.coroutines.flow.collectLatest
//import kotlinx.coroutines.launch
//
//@AndroidEntryPoint
//class DetailsFragment : Fragment() {
//
//    private var binding: FragmentDetailsBinding? = null // Привязка будет храниться здесь
//
//    private val viewModel: DetailsViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding = FragmentDetailsBinding.inflate(inflater, container, false)
//        return binding?.root ?: throw IllegalStateException("Binding is null")
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        // Получаем идентификатор астероида из аргументов фрагмента (например, из NavArgs)
//        val asteroidId = arguments?.getString("ASTEROID_ID") ?: return
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
//                    is DetailsFragmentState.DetailsLoaded -> {
//                        displayAsteroidDetails(state.asteroid)
//                    }
//                    is DetailsFragmentState.Error -> {
//                        showError(state.message)
//                    }
//                }
//            }
//        }
//    }
//
//    private fun displayAsteroidDetails(asteroid: Asteroids) {
//        binding?.nameTextView?.text = asteroid.name // Используем безопасный вызов
//        binding?.diameterTextView?.text = "Diameter: ${asteroid.estimatedDiameterMin} - ${asteroid.estimatedDiameterMax} km"
//        binding?.hazardousTextView?.text = if (asteroid.isPotentiallyHazardous) "Potentially Hazardous" else "Not Hazardous"
//    }
//
//    private fun showError(message: String) {
//        binding?.errorTextView?.text = message // Предполагается наличие TextView для ошибок
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null // Освобождение привязки при уничтожении представления
//    }
//}
//
