package com.example.todo.ui.home.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.ItemCategoryManageBinding
import com.example.todo.model.Category

class CategoryManageAdapter(private val itemClickListener: (Category, View, Int) -> Unit) :
    ListAdapter<Category, CategoryManageAdapter.ManageViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ManageViewHolder(
            ItemCategoryManageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: ManageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun notifyEdit(position: Int) {
        notifyItemChanged(position)
    }

    inner class ManageViewHolder(private val binding: ItemCategoryManageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.ivMenu.setOnClickListener {
                itemClickListener(getItem(adapterPosition), it, adapterPosition)
            }
        }

        fun bind(item: Category) {
            binding.item = item
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Category>() {
            override fun areItemsTheSame(oldItem: Category, newItem: Category) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Category, newItem: Category) =
                oldItem.id == newItem.id && oldItem.text == newItem.text
        }
    }
}
