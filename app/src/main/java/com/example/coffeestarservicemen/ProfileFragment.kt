package com.example.coffeestarservicemen

import android.graphics.BlurMaskFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.adapter.HistoryCodeAdapter
import com.example.coffeestarservicemen.databinding.FragmentProfileBinding
import com.example.coffeestarservicemen.decoration.CustomItemDecorationHistoryCode
import com.example.coffeestarservicemen.model.ItemsHistoryCode
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var bottomSheetDialog:BottomSheetDialog

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        blur()

        binding.btnCodeUpdate.setOnClickListener {
            if (binding.btnCodeUpdate.isActivated){
                binding.btnCodeUpdate.isActivated = false
                binding.btnCodeUpdate.text = "Показать код"
                blur()
            }else{
                binding.btnCodeUpdate.isActivated = true
                binding.btnCodeUpdate.text = "Скрыть код"
                noBlur()
            }
        }

        bottomSheetDialog = BottomSheetDialog(requireContext())
        createDialog()

        binding.containerHistory.setOnClickListener {
            bottomSheetDialog.show()
        }
    }

    private fun createDialog(){
        val sheetView = layoutInflater.inflate(R.layout.bottom_dialog_history_code,null, false)
        sheetView.findViewById<ImageView>(R.id.iv_close).setOnClickListener {
            bottomSheetDialog.dismiss()
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

        sheetView.findViewById<RecyclerView>(R.id.rv_code_history).apply {
            dividerDrawable?.let { CustomItemDecorationHistoryCode(space = space, divider = it) }?.let { addItemDecoration(it) }
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter =  HistoryCodeAdapter(items = list)
        }

        bottomSheetDialog.setContentView(sheetView)
        bottomSheetDialog.setCancelable(false)
    }

    private fun blur(){
        val textView = binding.tvPersonCode
        val radius = textView.textSize
        val filter = BlurMaskFilter(radius, BlurMaskFilter.Blur.NORMAL)
        textView.paint.maskFilter = filter
        textView.invalidate()
    }
    private fun noBlur(){
        binding.tvPersonCode.paint.maskFilter = null
        binding.tvPersonCode.invalidate()
    }
}