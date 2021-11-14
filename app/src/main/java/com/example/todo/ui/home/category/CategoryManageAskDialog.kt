package com.example.todo.ui.home.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.todo.databinding.DialogCategoryDeleteBinding
import com.example.todo.model.Category
import com.example.todo.ui.home.HomeViewModel

class CategoryManageAskDialog(private val viewModel: HomeViewModel,private val category: Category) : DialogFragment() {

    private var _binding: DialogCategoryDeleteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogCategoryDeleteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvCancel.setOnClickListener {
            dismiss()
        }

        binding.tvDelete.setOnClickListener {

        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
