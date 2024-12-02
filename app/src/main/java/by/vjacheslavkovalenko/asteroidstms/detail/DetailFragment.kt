package by.vjacheslavkovalenko.asteroidstms.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var binding: FragmentDetailBinding? = null // Привязка данных для фрагмента

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding!!.root // Возвращаем корневое представление привязки
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Получение данных астероида, переданных из MainFragment.
        val args: DetailFragmentArgs by navArgs()
        val asteroid = args.selectedAsteroid // Получаем астероид из аргументов

        // Установка значений в TextViews
        binding?.closeApproachDate?.text = asteroid.closeApproachDate
        binding?.absoluteMagnitude?.text = asteroid.absoluteMagnitude.toString()
        binding?.estimatedDiameter?.text = asteroid.estimatedDiameter.toString()
        binding?.relativeVelocity?.text = asteroid.relativeVelocity.toString()
        binding?.distanceFromEarth?.text = asteroid.distanceFromEarth.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null // Освобождение ссылки при уничтожении фрагмента
    }
}