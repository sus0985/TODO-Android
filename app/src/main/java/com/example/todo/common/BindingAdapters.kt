package com.example.todo.common

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.model.Category
import com.example.todo.ui.home.HomeCategoryAdapter
import com.example.todo.ui.home.category.CategoryManageAdapter

@BindingAdapter("bind:setHomeCategoryItems")
fun setHomeTagItems(listAdapter: RecyclerView, list: List<Category>?) {
    (listAdapter.adapter as HomeCategoryAdapter).submitList(list)
}

@BindingAdapter("bind:setCategoryManageItems")
fun setCategoryManageItems(listAdapter: RecyclerView, list: List<Category>?) {
    (listAdapter.adapter as CategoryManageAdapter).submitList(list)
}
