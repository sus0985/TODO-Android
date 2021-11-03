package com.example.todo.ui.home

import android.os.Bundle
import android.view.View
import com.example.todo.R
import com.example.todo.databinding.FragmentHomeBinding
import com.example.todo.ui.base.BaseFragment
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment :
    BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModel()
    private val adapter: HomeTagAdapter by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        binding.rvTagHome.adapter = adapter
    }
}
