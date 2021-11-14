package com.example.todo.ui.home.category

import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
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
        CategoryManageAdapter { category, view, position ->
            PopupMenu(requireContext(), view).also { popup ->
                popup.menuInflater.inflate(R.menu.category_edit_menu, popup.menu)
                popup.setOnMenuItemClickListener { menu ->
                    when (menu.itemId) {
                        R.id.category_edit -> {
                            CategoryEditDialog(
                                viewModel,
                                category
                            ) {
                                adapter.notifyEdit(position)
                            }.show(requireActivity().supportFragmentManager, null)
                        }
                        R.id.category_delete -> {
                            CategoryManageAskDialog(
                                viewModel,
                                category
                            ).show(requireActivity().supportFragmentManager, null)
                        }
                    }
                    false
                }
            }.show()
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
            CategoryManageAddDialog(viewModel).show(requireActivity().supportFragmentManager, null)
        }
    }
}
