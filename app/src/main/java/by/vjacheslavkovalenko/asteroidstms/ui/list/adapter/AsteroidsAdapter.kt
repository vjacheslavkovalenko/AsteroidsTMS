package by.vjacheslavkovalenko.asteroidstms.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.databinding.ItemAsteroidsBinding
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids

class AsteroidsAdapter(
    private val onClick: (asteroids: Asteroids) -> Unit
) : PagingDataAdapter<Asteroids, AsteroidsViewHolder>(
    object : DiffUtil.ItemCallback<Asteroids>() {
        override fun areItemsTheSame(oldItem: Asteroids, newItem: Asteroids): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Asteroids, newItem: Asteroids): Boolean {
            return oldItem.asteroidId == newItem.asteroidId
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidsViewHolder {
        return AsteroidsViewHolder(
            ItemAsteroidsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: AsteroidsViewHolder, position: Int) {
        getItem(position)?.let { asteroids: Asteroids ->
            holder.bind(asteroids)
            holder.itemView.setOnClickListener {
                onClick(asteroids)
            }
        }
    }


}






















