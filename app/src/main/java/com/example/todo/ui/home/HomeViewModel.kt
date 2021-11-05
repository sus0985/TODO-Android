package com.example.todo.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.model.Category
import com.example.todo.repository.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository) : ViewModel() {
    private val _items = MutableLiveData<List<Category>>()
    val items get() = _items

    init {
        viewModelScope.launch {
            _items.postValue(repository.getAllTagOrNull())
        }
    }
}
