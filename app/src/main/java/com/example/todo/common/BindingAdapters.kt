package com.example.todo.common

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.model.Tag
import com.example.todo.ui.home.HomeTagAdapter

@BindingAdapter("bind:setHomeTagItems")
fun setHomeTagItems(listAdapter: RecyclerView, list: List<Tag>) {
    (listAdapter.adapter as HomeTagAdapter).submitList(list)
}
