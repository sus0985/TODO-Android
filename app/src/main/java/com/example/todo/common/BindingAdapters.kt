package com.example.todo.common

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.model.Category
import com.example.todo.ui.home.HomeCategoryAdapter

@BindingAdapter("bind:setHomeTagItems")
fun setHomeTagItems(listAdapter: RecyclerView, list: List<Category>?) {
    (listAdapter.adapter as HomeCategoryAdapter).submitList(list)
}
