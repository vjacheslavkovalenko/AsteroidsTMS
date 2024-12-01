package by.vjacheslavkovalenko.asteroidstms.ui.list.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.vjacheslavkovalenko.asteroidstms.databinding.ItemAsteroidsBinding
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids


//555
class AsteroidsViewHolder(
    private val binding: ItemAsteroidsBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(asteroids: Asteroids) {
        binding.nameTextViewNameAsteroid.text = asteroids.nameAsteroid // Отображение имени астероида
        binding.nameTextViewAsteroidId.text = asteroids.asteroidId // Отображение идентификатора астероида
    }
}
