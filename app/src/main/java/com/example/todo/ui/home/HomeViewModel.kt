package com.example.todo.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todo.model.Tag

class HomeViewModel : ViewModel() {
    private val _items = MutableLiveData<List<Tag>>()
    val items get() = _items

    init {
        _items.value = listOf(
            Tag(1, "TAG")
        )
    }
}
