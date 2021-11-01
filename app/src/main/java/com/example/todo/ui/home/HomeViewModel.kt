package com.example.todo.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.model.Tag
import com.example.todo.repository.HomeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository) : ViewModel() {
    private val _items = MutableLiveData<List<Tag>>()
    val items get() = _items

    init {
//        _items.value = listOf(Tag(1, "asdf"))
        viewModelScope.launch {
            _items.postValue(repository.getAllTagOrNull())
        }
    }
}
