package com.example.todo.common

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.model.Category
import com.example.todo.model.ColorCode
import com.example.todo.ui.home.HomeCategoryAdapter
import com.example.todo.ui.home.category.CategoryManageAdapter
import com.example.todo.ui.home.category.ColorAdapter

@BindingAdapter("bind:setHomeCategoryItems")
fun setHomeTagItems(listAdapter: RecyclerView, list: List<Category>?) {
    (listAdapter.adapter as HomeCategoryAdapter).submitList(list)
}

@BindingAdapter("bind:setCategoryManageItems")
fun setCategoryManageItems(listAdapter: RecyclerView, list: List<Category>?) {
    (listAdapter.adapter as CategoryManageAdapter).submitList(list)
}

@BindingAdapter("setColor")
fun setColor(view: View, color: String) {
    view.backgroundTintList = ColorStateList.valueOf(Color.parseColor(color))
}

@BindingAdapter("bind:setColorItems")
fun setColorItems(listAdapter: RecyclerView, list: List<ColorCode>?) {
    (listAdapter.adapter as ColorAdapter).submitList(list)
}
