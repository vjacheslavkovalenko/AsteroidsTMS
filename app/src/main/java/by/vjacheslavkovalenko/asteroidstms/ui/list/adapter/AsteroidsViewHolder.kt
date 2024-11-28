package by.vjacheslavkovalenko.asteroidstms.ui.list.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.vjacheslavkovalenko.asteroidstms.databinding.ItemAsteroidsBinding
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids

//class AsteroidsViewHolder(
//    private val binding: ItemAsteroidsBinding
//) : ViewHolder(binding.root) {
//
//    fun bind(asteroids: Asteroids) {
//        binding.nameTextView.text = asteroids.asteroidId
//    }
//}

class AsteroidsViewHolder(
    private val binding: ItemAsteroidsBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(asteroids: Asteroids) {
        binding.nameTextViewNameAsteroid .text = asteroids.nameAsteroid // Пример отображения имени астероида
        binding.nameTextViewAsteroidId.text = asteroids.asteroidId // Пример отображения имени астероида
    }
}