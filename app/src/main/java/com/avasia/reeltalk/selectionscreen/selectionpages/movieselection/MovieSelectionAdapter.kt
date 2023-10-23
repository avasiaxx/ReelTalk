package com.avasia.reeltalk.selectionscreen.selectionpages.movieselection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.avasia.reeltalk.R
import com.avasia.reeltalk.data.models.Show
import com.avasia.reeltalk.databinding.SelectionItemBinding

class MovieSelectionAdapter(
    private val onShowSelected: (Show) -> Unit
) : RecyclerView.Adapter<MovieSelectionAdapter.ViewHolder>() {

    private val values = mutableListOf<Show>()

    inner class ViewHolder(
        private val binding: SelectionItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Show) {
            binding.image.setImageResource(movie.image)
            binding.title.text = movie.showName
            binding.image.setOnClickListener {
                onShowSelected(movie)
                binding.image.setBackgroundResource(if (movie.selected) R.drawable.border else 0)
                binding.checkMark.visibility = if (movie.selected) View.VISIBLE else View.INVISIBLE
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

    fun setItems(items: List<Show>?) {
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