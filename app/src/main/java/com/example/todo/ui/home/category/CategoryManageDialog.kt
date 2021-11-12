package com.example.todo.ui.home.category

import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.DialogFragment
import com.example.todo.databinding.DialogCategoryManageBinding
import com.example.todo.model.Category
import com.example.todo.model.ColorCode
import com.example.todo.ui.home.HomeViewModel

class CategoryManageDialog(private val viewModel: HomeViewModel) : DialogFragment() {

    private var _binding: DialogCategoryManageBinding? = null
    private val binding get() = _binding!!
    private var category = ""
    private val adapter by lazy {
        ColorAdapter {
            viewModel.selectColor(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogCategoryManageBinding.inflate(inflater, container, false)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.etCategory.doAfterTextChanged {
            binding.tvTextCount.text = String.format("%02d", it?.length)
            category = it.toString()
        }

        binding.btnCancel.setOnClickListener {
            dismiss()
        }

        binding.btnSave.setOnClickListener {
            viewModel.insertCategory(Category(category, ColorCode.CHOCOLATE, 0))
            viewModel.loadAllCategory()
            dismiss()
        }

        binding.rvColor.adapter = adapter
    }

    override fun onResume() {
        super.onResume()

        val size = Point()

        // Version 분기
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            context?.display?.getRealSize(size)
        } else {
            val windowManager =
                requireActivity().getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val display = windowManager.defaultDisplay
            display.getSize(size)
        }

        dialog?.window?.attributes = dialog?.window?.attributes?.apply {
            width = (size.x * 0.9).toInt()
            height = WindowManager.LayoutParams.WRAP_CONTENT
        }
    }
}
