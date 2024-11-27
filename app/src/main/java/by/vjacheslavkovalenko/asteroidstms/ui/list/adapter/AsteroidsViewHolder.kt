package by.vjacheslavkovalenko.asteroidstms.ui.list.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.vjacheslavkovalenko.asteroidstms.databinding.ItemAsteroidsBinding
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids

class AsteroidsViewHolder(private val binding: ItemAsteroidsBinding) : ViewHolder(binding.root) {

    fun bind(asteroids: Asteroids) {
        binding.nameTextView.text = asteroids.asteroidId
    }
}