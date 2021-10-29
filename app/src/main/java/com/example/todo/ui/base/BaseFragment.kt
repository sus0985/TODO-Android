package com.example.todo.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlin.reflect.KClass

abstract class BaseFragment<V : ViewModel, T : ViewDataBinding>(
    private val layoutID: Int,
    private val kClass: KClass<V>
) : Fragment() {

    private var _binding: T? = null
    protected val binding get() = _binding!!
    protected lateinit var viewModel: V

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutID, container, false)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this).get(kClass.java) as V
        return binding.root
    }
}
