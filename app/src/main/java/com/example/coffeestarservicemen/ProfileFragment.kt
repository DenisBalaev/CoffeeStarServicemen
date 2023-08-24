package com.example.coffeestarservicemen

import android.graphics.BlurMaskFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coffeestarservicemen.bottomsheet.HistoryCodeBottomSheetFragment
import com.example.coffeestarservicemen.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var bottomSheetDialog:HistoryCodeBottomSheetFragment

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

        bottomSheetDialog = HistoryCodeBottomSheetFragment()

        binding.ivHistory.setOnClickListener {
            bottomSheetDialog.show(childFragmentManager,bottomSheetDialog.tag)
        }
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