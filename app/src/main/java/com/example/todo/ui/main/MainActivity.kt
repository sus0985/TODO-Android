package com.example.todo.ui.main

import android.os.Bundle
import com.example.todo.R
import com.example.todo.databinding.ActivityMainBinding
import com.example.todo.ui.base.BaseActivity

class MainActivity :
    BaseActivity<MainViewModel, ActivityMainBinding>(R.layout.activity_main, MainViewModel::class) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel
    }
}
