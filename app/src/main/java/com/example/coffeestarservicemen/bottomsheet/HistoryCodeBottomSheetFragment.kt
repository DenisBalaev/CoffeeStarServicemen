package com.example.coffeestarservicemen.bottomsheet

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.adapter.HistoryCodeAdapter
import com.example.coffeestarservicemen.databinding.BottomDialogHistoryCodeBinding
import com.example.coffeestarservicemen.decoration.CustomItemDecorationHistoryCode
import com.example.coffeestarservicemen.model.ItemsHistoryCodeModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class HistoryCodeBottomSheetFragment : BottomSheetDialogFragment(R.layout.bottom_dialog_history_code) {

    private val binding by viewBinding(BottomDialogHistoryCodeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        isCancelable = false

        binding.ivClose.setOnClickListener {
            dismiss()
        }

        val list = mutableListOf<ItemsHistoryCodeModel>(
            ItemsHistoryCodeModel(date = "15 декабря", code = "2RD 54W"),
            ItemsHistoryCodeModel(date = "11 июня", code = "V99 HJ1"),
            ItemsHistoryCodeModel(date = "9 апреля", code = "RQ5 8CP")
        )

        repeat(3){
            list.addAll(list)
        }

        val space = resources.getDimensionPixelSize(R.dimen.marginTop_recyclerView_HistoryCode)
        val dividerDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.vertical_divider_history_code)

        binding.rvCodeHistory.apply {
            dividerDrawable?.let { CustomItemDecorationHistoryCode(space = space, divider = it) }?.let { addItemDecoration(it) }
            layoutManager = LinearLayoutManager(requireContext())
            adapter =  HistoryCodeAdapter(items = list)
        }
    }

}