package com.example.todo.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlin.reflect.KClass

abstract class BaseActivity<V : ViewModel, T : ViewDataBinding>(
    private val layoutId: Int,
    private val className: KClass<V>
) :
    AppCompatActivity() {

    private lateinit var _binding: T
    protected lateinit var viewModel: V
    protected val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(className.java)
        _binding = DataBindingUtil.setContentView(this, layoutId)

        binding.lifecycleOwner = this
    }
}
