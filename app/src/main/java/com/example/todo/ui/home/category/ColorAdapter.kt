package com.example.todo.ui.home.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.ItemColorBinding
import com.example.todo.model.ColorCode

class ColorAdapter(private val itemClickListener: (ColorCode) -> Unit) :
    ListAdapter<ColorCode, ColorAdapter.ColorViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        return ColorViewHolder(
            ItemColorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ColorViewHolder(private val binding: ItemColorBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                itemClickListener(getItem(adapterPosition))
            }
        }

        fun bind(item: ColorCode) {
            binding.color = item
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ColorCode>() {
            override fun areItemsTheSame(oldItem: ColorCode, newItem: ColorCode) =
                oldItem.code == newItem.code

            override fun areContentsTheSame(oldItem: ColorCode, newItem: ColorCode) =
                oldItem == newItem
        }
    }
}
