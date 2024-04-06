package com.example.androiddemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddemo.R
import com.example.androiddemo.databinding.ItemFigureBinding
import com.example.androiddemo.model.Figures

class FiguresAdapter : ListAdapter<Figures, FiguresAdapter.FigureViewHolder>(FigureDiffCallback()){

    private var figuresList: List<Figures> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FigureViewHolder {
        val binding = ItemFigureBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val dividerView = LayoutInflater.from(parent.context).inflate(R.layout.divider_item, parent, false)
        return FigureViewHolder(binding, dividerView)
    }

    override fun onBindViewHolder(holder: FigureViewHolder, position: Int) {
        val figure = figuresList[position]
        holder.bind(figure)
        val isLastItem = position == itemCount - 1

        holder.dividerView.visibility = if (!isLastItem) View.VISIBLE else View.GONE
    }

    override fun getItemCount(): Int {
        return figuresList.size
    }

    fun updateData(newList: List<Figures>) {
        figuresList = newList
        notifyDataSetChanged()
    }

    fun updateList(newList: List<Figures>) {
        figuresList = newList
        submitList(newList)
    }

    class FigureViewHolder(private val binding: ItemFigureBinding, val dividerView: View) : RecyclerView.ViewHolder(binding.root) {
        fun bind(figure: Figures) {
            binding.nameTextView.text = "Name: ${figure.name}"
            binding.titleTextView.text = "Title: ${figure.title ?: "Unknown"}"
            binding.parentsTextView.text = "Parents: ${figure.info.father ?: "Unknown"} and ${figure.info.mother ?: "Unknown"}"
            binding.bornTextView.text = "Born: ${figure.info.born ?: "Unknown"}"
            binding.diedTextView.text = "Died: ${figure.info.died ?: "Unknown"}"

        }
    }
    class FigureDiffCallback : DiffUtil.ItemCallback<Figures>() {
        override fun areItemsTheSame(oldItem: Figures, newItem: Figures): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Figures, newItem: Figures): Boolean {
            return oldItem == newItem
        }
    }



}
