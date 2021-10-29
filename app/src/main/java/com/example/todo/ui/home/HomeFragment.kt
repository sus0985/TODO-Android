package com.example.todo.ui.home

import android.os.Bundle
import android.view.View
import com.example.todo.R
import com.example.todo.databinding.FragmentHomeBinding
import com.example.todo.ui.base.BaseFragment

class HomeFragment :
    BaseFragment<HomeViewModel, FragmentHomeBinding>(R.layout.fragment_home, HomeViewModel::class) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }


}
