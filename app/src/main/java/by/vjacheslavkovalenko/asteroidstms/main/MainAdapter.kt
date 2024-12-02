package by.vjacheslavkovalenko.asteroidstms.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.vjacheslavkovalenko.asteroidstms.databinding.AsteroidItemBinding
import by.vjacheslavkovalenko.asteroidstms.domain.Asteroid

class MainAdapter : ListAdapter<Asteroid, MainAdapter.AsteroidViewHolder>(AsteroidDiffCallback()) {

    private var onItemClickListener: ((Asteroid) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidViewHolder {
        val binding = AsteroidItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AsteroidViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AsteroidViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class AsteroidViewHolder(private val binding: AsteroidItemBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener { onItemClickListener?.invoke(getItem(adapterPosition)) }
        }

        fun bind(asteroid: Asteroid) {
            binding.apply {
                this.asteroid = asteroid // Использование привязки данных.
                executePendingBindings() // Обновление привязки данных.
            }
        }
    }

    fun setOnItemClickListener(listener: (Asteroid) -> Unit) {
        onItemClickListener = listener
    }
}

class AsteroidDiffCallback : DiffUtil.ItemCallback<Asteroid>() {
    override fun areItemsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
        return oldItem.id == newItem.id // Сравнение по ID.
    }

    override fun areContentsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
        return oldItem == newItem // Сравнение содержимого.
    }
}