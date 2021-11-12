package com.example.todo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.model.Category
import com.example.todo.model.ColorCode
import com.example.todo.repository.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository) : ViewModel() {
    private val _items = MutableLiveData<List<Category>>()
    val items: LiveData<List<Category>> get() = _items

    private val _colors = MutableLiveData(
        listOf(
            ColorCode.BLACK,
            ColorCode.LIGHT_YELLOW,
            ColorCode.LIGHT_BLUE,
            ColorCode.DARK_BLUE,
            ColorCode.DARK_GREEN,
            ColorCode.DARK_RED,
            ColorCode.PINK,
            ColorCode.CHOCOLATE
        )
    )

    val colors: LiveData<List<ColorCode>> get() = _colors

    private val _selectedColor = MutableLiveData(ColorCode.CHOCOLATE)
    val selectedColor: LiveData<ColorCode> get() = _selectedColor

    init {
        viewModelScope.launch {
            _items.postValue(repository.loadAllCategoryOrNull())
        }
    }

    fun insertCategory(category: Category) {
        viewModelScope.launch {
            repository.insertCategory(category)
        }
    }

    fun loadAllCategory() {
        viewModelScope.launch {
            _items.postValue(repository.loadAllCategoryOrNull())
        }
    }

    fun selectColor(color: ColorCode) {
        _selectedColor.value = color
    }
}
