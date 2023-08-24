package com.example.coffeestarservicemen

import android.graphics.BlurMaskFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.coffeestarservicemen.databinding.FragmentProfileBinding
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

        binding.ivHistory.setOnClickListener {
            bottomSheetDialog.show()
        }

        val bottomSheetInternal: View? = bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet)
        if (bottomSheetInternal != null) {
            BottomSheetBehavior.from(bottomSheetInternal).isDraggable = false
        }
    }

    private fun createDialog(){
        val sheetView = layoutInflater.inflate(R.layout.bottom_dialog_history_code,null, false)
        sheetView.findViewById<ImageView>(R.id.iv_close).setOnClickListener {
            bottomSheetDialog.dismiss()
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