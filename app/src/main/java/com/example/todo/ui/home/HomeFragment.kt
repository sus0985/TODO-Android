package com.example.todo.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.PopupMenu
import androidx.navigation.fragment.findNavController
import com.example.todo.R
import com.example.todo.databinding.FragmentHomeBinding
import com.example.todo.ui.base.BaseFragment
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment :
    BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by sharedViewModel()
    private val adapter: HomeCategoryAdapter by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        binding.rvTagHome.adapter = adapter

        initClickListener()
    }

    private fun initClickListener() {

        binding.btnMenu.setOnClickListener {
            PopupMenu(requireContext(), it).also { popup ->
                popup.menuInflater.inflate(R.menu.category_menu, popup.menu)
                popup.setOnMenuItemClickListener { menu ->
                    when (menu.itemId) {
                        R.id.category_management -> {
                            findNavController().navigate(R.id.action_navigation_home_to_fragment_category_manage)
                        }
                        R.id.task_search -> {

                        }
                    }
                    false
                }
            }.show()
        }
    }
}
