package com.example.todo.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.ItemHomeTagBinding
import com.example.todo.model.Tag

class HomeTagAdapter : ListAdapter<Tag, HomeTagAdapter.TagViewHolder>(TagDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        return TagViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TagViewHolder(private val binding: ItemHomeTagBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Tag) {
            binding.tvTagContent.text = item.text
        }

        companion object {
            fun from(parent: ViewGroup) =
                TagViewHolder(
                    ItemHomeTagBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
        }
    }

    companion object {
        class TagDiffUtil : DiffUtil.ItemCallback<Tag>() {
            override fun areItemsTheSame(oldItem: Tag, newItem: Tag) = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Tag, newItem: Tag) = oldItem == newItem

        }
    }
}
