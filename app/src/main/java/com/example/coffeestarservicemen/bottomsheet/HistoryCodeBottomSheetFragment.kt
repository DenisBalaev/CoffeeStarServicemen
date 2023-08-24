package com.example.coffeestarservicemen.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.adapter.HistoryCodeAdapter
import com.example.coffeestarservicemen.databinding.BottomDialogHistoryCodeBinding
import com.example.coffeestarservicemen.decoration.CustomItemDecorationHistoryCode
import com.example.coffeestarservicemen.model.ItemsHistoryCode
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class HistoryCodeBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding : BottomDialogHistoryCodeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomDialogHistoryCodeBinding.inflate(layoutInflater)
        isCancelable = false
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.ivClose.setOnClickListener {
            dismiss()
        }

        val list = mutableListOf<ItemsHistoryCode>(
            ItemsHistoryCode(date = "15 декабря", code = "2RD 54W"),
            ItemsHistoryCode(date = "11 июня", code = "V99 HJ1"),
            ItemsHistoryCode(date = "9 апреля", code = "RQ5 8CP")
        )

        repeat(6){
            list.addAll(list)
        }

        val space = resources.getDimensionPixelSize(R.dimen.marginTop_recyclerView_HistoryCode)
        val dividerDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.vertical_divider_history_code)

        binding.rvCodeHistory.apply {
            dividerDrawable?.let { CustomItemDecorationHistoryCode(space = space, divider = it) }?.let { addItemDecoration(it) }
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter =  HistoryCodeAdapter(items = list)
        }
    }

}