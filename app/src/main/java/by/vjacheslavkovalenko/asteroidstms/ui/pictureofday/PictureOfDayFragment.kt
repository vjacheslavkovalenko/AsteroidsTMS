package by.vjacheslavkovalenko.asteroidstms.ui.pictureofday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentPictureOfDayBinding
import by.vjacheslavkovalenko.asteroidstms.model.PictureOfDay
import by.vjacheslavkovalenko.asteroidstms.ui.pictureofday.domain.PictureFragmentState
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PictureOfDayFragment : Fragment() {

    private var binding: FragmentPictureOfDayBinding? = null
    private val viewModel: PictureOfDayViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return FragmentPictureOfDayBinding.inflate(layoutInflater, container, false).also {
//            binding = it
//        }.root
        binding = FragmentPictureOfDayBinding.inflate(inflater, container, false)
        return binding?.root ?: throw IllegalStateException("Binding is null")
//        binding = FragmentPictureOfDayBinding.inflate(inflater)
//        return binding?.root
    }

    //    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        lifecycleScope.launch {
//            viewModel.state.collectLatest { state ->
//                when (state) {
//                    ListFragmentState.Init -> {}
//                    is ListFragmentState.ListLoaded -> {
//                        state.flowPagingData.collectLatest {
//                            setList(it)
//                        }
//                    }
//                }
//            }
//        }
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                when (state) {
                    is PictureFragmentState.Init -> {}
                    is PictureFragmentState.PictureLoaded -> {
                        displayPicture(state.picture)
                    }

                    is PictureFragmentState.Error -> {
                        showError(state.message)
                    }
                }
            }
        }

        // Загружаем картину дня при создании фрагмента
        viewModel.loadPicture()
    }


    private fun displayPicture(picture: PictureOfDay) {
        binding?.imageViewPictureOfDayDetail?.let { imageView ->
            Glide.with(this).load(picture.url)
                .into(imageView) // Используйте библиотеку Glide для загрузки изображений.
        }
        binding?.textViewDescription?.text = picture.explanation
    }

    private fun showError(message: String) {
        binding?.errorTextView?.text = message // Предполагается наличие TextView для ошибок.
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null // Освобождение привязки при уничтожении представления
    }
}

//        viewModel.image.observe(viewLifecycleOwner) {
//            binding?.image?.loadUrl(it.message)
//            binding?.errorText?.visibility = View.GONE
//            binding?.tryAgainButton?.visibility = View.GONE
//            binding?.image?.visibility = View.VISIBLE
//        }
//        viewModel.showError = {
//            binding?.errorText?.visibility = View.VISIBLE
//            binding?.tryAgainButton?.visibility = View.VISIBLE
//            binding?.image?.visibility = View.GONE
//        }
//        binding?.tryAgainButton?.setOnClickListener {
//            viewModel.loadDogImage()
//        }
//        viewModel.loadDogImage()

//----------------------моё--class ListFragment : Fragment() {-----это для списка астероидов-------------
//private var binding: FragmentListBinding? = null
//
//    private val viewModel: ListViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return FragmentListBinding.inflate(layoutInflater, container, false).also {
//            binding = it
//        }.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        lifecycleScope.launch {
//            viewModel.state.collectLatest { state ->
//                when (state) {
//                    ListFragmentState.Init -> {}
//                    is ListFragmentState.ListLoaded -> {
//                        state.flowPagingData.collectLatest {
//                            setList(it)
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    private suspend fun setList(list: PagingData<Asteroids>) {
//        binding?.recyclerView?.run {
//            if (adapter == null) {
//                layoutManager = LinearLayoutManager(requireContext())
//                adapter = AsteroidsAdapter {
//
//                }
//            }
//            (adapter as? AsteroidsAdapter)?.submitData(list)
//        }
//
//    }

//-----------------------конец моё---------------------
//
//    private var binding: FragmentDogImageBinding? = null
//
//    private val viewModel: DogImageViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentDogImageBinding.inflate(inflater)
//        return binding?.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel.image.observe(viewLifecycleOwner) {
//            binding?.image?.loadUrl(it.message)
//            binding?.errorText?.visibility = View.GONE
//            binding?.tryAgainButton?.visibility = View.GONE
//            binding?.image?.visibility = View.VISIBLE
//        }
//        viewModel.showError = {
//            binding?.errorText?.visibility = View.VISIBLE
//            binding?.tryAgainButton?.visibility = View.VISIBLE
//            binding?.image?.visibility = View.GONE
//        }
//        binding?.tryAgainButton?.setOnClickListener {
//            viewModel.loadDogImage()
//        }
//        viewModel.loadDogImage()
//    }
//


//***PERPLEX***V2
//
//package by.vjacheslavkovalenko.asteroidstms.ui.pictureofday
//
//import android.os.Bundle
// import android.view.LayoutInflater
// import android.view.View
// import android.view.ViewGroup
// import androidx.fragment.app.Fragment
// import androidx.fragment.app.viewModels
// import androidx.lifecycle.lifecycleScope
// import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentPictureofdayBinding
// import dagger.hilt.android.AndroidEntryPoint
// import kotlinx.coroutines.flow.collectLatest
// import kotlinx.coroutines.launch
//
//@AndroidEntryPoint
//class PictureOfTheDayFragment : Fragment() {
//
//      private var _binding: FragmentPictureofdayBinding? = null
//      private val binding get() = _binding!!
//
//      private val viewModel: PictureOfTheDayViewModel by viewModels()
//
//      override fun onCreateView(
//          inflater: LayoutInflater,
//          container: ViewGroup?,
//          savedInstanceState: Bundle?
//      ): View {
//          _binding = FragmentPictureofdayBinding.inflate(inflater, container, false)
//          return binding.root
//      }
//
//      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//          super.onViewCreated(view, savedInstanceState)
//
//          lifecycleScope.launch {
//              viewModel.state.collectLatest { state ->
//                  when (state) {
//                      is PictureFragmentState.Init -> {}
//                      is PictureFragmentState.PictureLoaded -> {
//                          displayPicture(state.picture)
//                      }
//                      is PictureFragmentState.Error -> {
//                          showError(state.message)
//                      }
//                  }
//              }
//          }
//
//          // Загружаем картину дня при создании фрагмента
//          viewModel.loadPicture()
//      }
//
//      private fun displayPicture(picture: PictureOfDay) {
//          binding.titleTextView.text = picture.title
//          binding.explanationTextView.text = picture.explanation
//          // Загрузите изображение по URL (например, с помощью Glide или Picasso)
//      }
//
//      private fun showError(message: String) {
//          binding.errorTextView.text = message // Предполагается наличие TextView для ошибок
//      }
//
//      override fun onDestroyView() {
//          super.onDestroyView()
//          _binding = null // Освобождение привязки при уничтожении представления
//      }
//}


//***PERPLEX***V3---попросил заменить private val binding get() = _binding!!
//
//package by.vjacheslavkovalenko.asteroidstms.ui.pictureofday
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
//import androidx.lifecycle.lifecycleScope
//import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentPictureofdayBinding
//import dagger.hilt.android.AndroidEntryPoint
//import kotlinx.coroutines.flow.collectLatest
//import kotlinx.coroutines.launch
//
//@AndroidEntryPoint
//class PictureOfTheDayFragment : Fragment() {
//
//    private var binding: FragmentPictureofdayBinding? = null // Привязка будет храниться здесь
//
//    private val viewModel: PictureOfTheDayViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding = FragmentPictureofdayBinding.inflate(inflater, container, false)
//        return binding?.root ?: throw IllegalStateException("Binding is null")
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        lifecycleScope.launch {
//            viewModel.state.collectLatest { state ->
//                when (state) {
//                    is PictureFragmentState.Init -> {
//                        // Инициализация UI, если необходимо
//                    }
//                    is PictureFragmentState.PictureLoaded -> {
//                        displayPicture(state.picture)
//                    }
//                    is PictureFragmentState.Error -> {
//                        showError(state.message)
//                    }
//                }
//            }
//        }
//
//        // Загружаем картину дня при создании фрагмента
//        viewModel.loadPicture()
//    }
//
//    private fun displayPicture(picture: PictureOfDay) {
//        binding?.titleTextView?.text = picture.title
//        binding?.explanationTextView?.text = picture.explanation
//        // Загрузите изображение по URL (например, с помощью Glide или Picasso)
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


//***PERPLEX***V4***XML
//
//package by.vjacheslavkovalenko.asteroidstms.ui.pictureofday
//
//class PictureOfTheDayFragment : Fragment() {
//
//    private var binding: FragmentPictureofdayBinding? = null
//
//    private val viewModel: PictureOfTheDayViewModel by viewModels()
//
//    override fun onCreateView(
//            inflater: LayoutInflater,
//            container: ViewGroup?,
//            savedInstanceState: Bundle?
//    ): View {
//            binding = FragmentPictureofdayBinding.inflate(inflater, container, false)
//            return binding?.root ?: throw IllegalStateException("Binding is null")
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//            super.onViewCreated(view, savedInstanceState)
//
//            lifecycleScope.launch {
//                viewModel.state.collectLatest { state ->
//                    when (state) {
//                        is PictureFragmentState.Init -> {}
//                        is PictureFragmentState.PictureLoaded -> {
//                            displayPicture(state.picture)
//                        }
//                        is PictureFragmentState.Error -> {
//                            showError(state.message)
//                        }
//                    }
//                }
//            }
//
//            // Загружаем картину дня при создании фрагмента
//            viewModel.loadPicture()
//    }
//
//    private fun displayPicture(picture: PictureOfDay) {
//         binding?.imageViewPictureOfDayDetail?.let { imageView ->
//             Glide.with(this).load(picture.url).into(imageView) // Используйте библиотеку Glide для загрузки изображений.
//         }
//         binding?.textViewDescription?.text = picture.explanation
//     }
//
//     private fun showError(message: String) {
//         binding?.errorTextView?.text = message // Предполагается наличие TextView для ошибок.
//     }
//
//     override fun onDestroyView() {
//         super.onDestroyView()
//         binding = null // Освобождение привязки при уничтожении представления
//     }
//}




