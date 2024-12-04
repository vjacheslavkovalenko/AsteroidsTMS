package by.vjacheslavkovalenko.asteroidstms.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.vjacheslavkovalenko.asteroidstms.databinding.AsteroidItemBinding
import by.vjacheslavkovalenko.asteroidstms.domain.Asteroid

class MainAdapter(private val onClick: (Asteroid) -> Unit) :
    ListAdapter<Asteroid, MainAdapter.AsteroidViewHolder>(AsteroidDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidViewHolder {
        val binding =
            AsteroidItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AsteroidViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AsteroidViewHolder, position: Int) {
        val asteroid = getItem(position)
        holder.bind(asteroid, onClick)
    }

    class AsteroidViewHolder(private val binding: AsteroidItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(asteroid: Asteroid, onClick: (Asteroid) -> Unit) {
            binding.codename.text = asteroid.codename
            binding.closeApproachDate.text = asteroid.closeApproachDate

            binding.root.setOnClickListener {
                onClick(asteroid)
            }
        }
    }

    class AsteroidDiffCallback : DiffUtil.ItemCallback<Asteroid>() {
        override fun areItemsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
            return oldItem == newItem
        }
    }
}
