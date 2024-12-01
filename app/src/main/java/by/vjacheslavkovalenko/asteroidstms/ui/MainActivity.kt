package by.vjacheslavkovalenko.asteroidstms.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import by.vjacheslavkovalenko.asteroidstms.R
import by.vjacheslavkovalenko.asteroidstms.ui.pictureofday.PictureOfDayFragment
import dagger.hilt.android.AndroidEntryPoint

//555
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Включаем режим "край к краю" для полноэкранного отображения
        setContentView(R.layout.activity_main)

        // Заменяем контейнер на фрагмент "PictureOfDayFragment"
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfDayFragment())
                .commit()
        }
    }
}
