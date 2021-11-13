package com.example.todo.ui.home.category

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.todo.R
import com.example.todo.databinding.FragmentCategoryManageBinding
import com.example.todo.ui.base.BaseFragment
import com.example.todo.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CategoryManageFragment :
    BaseFragment<FragmentCategoryManageBinding>(R.layout.fragment_category_manage) {

    private val viewModel: HomeViewModel by sharedViewModel()
    private val adapter: CategoryManageAdapter by lazy {
        CategoryManageAdapter {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.rvCategory.adapter = adapter

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnCreateCategory.setOnClickListener {
            CategoryManageDialog(viewModel).show(requireActivity().supportFragmentManager, null)
        }
    }
}
