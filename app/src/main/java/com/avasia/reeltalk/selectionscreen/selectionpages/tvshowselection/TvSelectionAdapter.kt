package com.avasia.reeltalk.selectionscreen.selectionpages.Tvselection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.avasia.reeltalk.R
import com.avasia.reeltalk.data.models.Show
import com.avasia.reeltalk.databinding.SelectionItemBinding

class TvSelectionAdapter(
    private val onShowSelected: (Show) -> Unit
) : RecyclerView.Adapter<TvSelectionAdapter.ViewHolder>() {

    private val values = mutableListOf<Show>()

    inner class ViewHolder(
        private val binding: SelectionItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tv: Show) {
            binding.image.setImageResource(tv.image)
            binding.title.text = tv.showName
            binding.image.setOnClickListener {
                onShowSelected(tv)
                binding.image.setBackgroundResource(if (tv.selected) R.drawable.border else 0)
                binding.checkMark.visibility = if (tv.selected) View.VISIBLE else View.INVISIBLE
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