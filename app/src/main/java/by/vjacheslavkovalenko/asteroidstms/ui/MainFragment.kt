package by.vjacheslavkovalenko.asteroidstms.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.vjacheslavkovalenko.asteroidstms.R
import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null

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

        binding?.buttonAboutApp?.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_aboutAppFragment)
        }

        binding?.buttonRadarAsteroids?.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_listFragment)
        }

        //пробую по клику на фото открыть новое окно (с ним и описанием)
        binding?.imageViewPictureOfDay?.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_pictureOfDayFragment)
        }




        binding?.buttonWhatAreAsteroids?.setOnClickListener {
            // Здесь можно добавить логику для отображения информации о астероидах.
        }

        // Загрузить картину дня через ViewModel или API и установить в ImageView и TextView.
        // Например:
        // loadPictureOfDay()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
