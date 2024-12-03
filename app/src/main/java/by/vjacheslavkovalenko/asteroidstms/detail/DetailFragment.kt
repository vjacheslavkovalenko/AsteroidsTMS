package by.vjacheslavkovalenko.asteroidstms.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.vjacheslavkovalenko.asteroidstms.R
import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentDetailBinding
import by.vjacheslavkovalenko.asteroidstms.domain.Asteroid
import by.vjacheslavkovalenko.asteroidstms.detail.DetailFragmentArgs

class DetailFragment : Fragment() {

    private var binding: FragmentDetailBinding? = null

    private val args: DetailFragmentArgs by navArgs() // Получение аргументов из навигации

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Получение астероида из аргументов
        val asteroid = args.selectedAsteroid

        // Отображение данных об астероиде
        displayAsteroidDetails(asteroid)
    }

    private fun displayAsteroidDetails(asteroid: Asteroid) {
        binding?.codename?.text = asteroid.codename
        binding?.closeApproachDate?.text = asteroid.closeApproachDate
        binding?.absoluteMagnitude?.text = asteroid.absoluteMagnitude.toString()
        binding?.estimatedDiameter?.text = asteroid.estimatedDiameter.toString()
        binding?.relativeVelocity?.text = asteroid.relativeVelocity.toString()
        binding?.distanceFromEarth?.text = asteroid.distanceFromEarth.toString()

        // Установка изображения статуса астероида
        val statusImageResId = if (asteroid.isPotentiallyHazardous) {
            R.drawable.asteroid_hazardous
        } else {
            R.drawable.asteroid_safe
        }
        binding?.statusImageView?.setImageResource(statusImageResId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}