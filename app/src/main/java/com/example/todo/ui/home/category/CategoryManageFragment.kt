package com.example.todo.ui.home.category

import android.os.Bundle
import android.view.View
import com.example.todo.R
import com.example.todo.databinding.FragmentCategoryManageBinding
import com.example.todo.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoryManageFragment :
    BaseFragment<FragmentCategoryManageBinding>(R.layout.fragment_category_manage) {

    private val viewModel: CategoryManageViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
    }
}