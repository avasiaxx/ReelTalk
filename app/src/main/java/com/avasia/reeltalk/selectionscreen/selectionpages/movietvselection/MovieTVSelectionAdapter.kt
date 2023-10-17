package com.avasia.reeltalk.selectionscreen.selectionpages.movietvselection

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.avasia.reeltalk.R
import com.avasia.reeltalk.data.models.Movie
import com.avasia.reeltalk.databinding.SelectionItemBinding

class MovieTVSelectionAdapter : RecyclerView.Adapter<MovieTVSelectionAdapter.ViewHolder>() {

    private val values = mutableListOf<Movie>()


    inner class ViewHolder(
        private val binding: SelectionItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private var selected = false
        fun bind(movie: Movie) {
            binding.image.setImageResource(movie.image)
            binding.title.text = movie.movieName
            binding.image.setOnClickListener {
                if (!selected) {
                    selected = true
                    binding.image.setBackgroundResource(R.color.colorPrimary)
                } else {
                    selected = false
                    binding.image.setBackgroundResource(0)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            SelectionItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun setItems(items: List<Movie>?) {
        this.values.apply {
            clear()
            if (items != null) {
                addAll(items)
            }
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.bind(item)
    }
}