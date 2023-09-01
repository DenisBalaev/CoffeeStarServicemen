package com.example.coffeestarservicemen.fragment

import android.graphics.BlurMaskFilter
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.BottomNavInterface
import com.example.coffeestarservicemen.MainActivity
import com.example.coffeestarservicemen.MyFragment
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.bottomsheet.HistoryCodeBottomSheetFragment
import com.example.coffeestarservicemen.databinding.FragmentProfileBinding


class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private val binding by viewBinding(FragmentProfileBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        blur()

        val bottomSheetDialog = HistoryCodeBottomSheetFragment()

        with(binding) {
            btnCodeBlur.setOnClickListener {
                if (btnCodeBlur.isActivated) {
                    btnCodeBlur.isActivated = false
                    btnCodeBlur.text = "Показать код"
                    blur()
                } else {
                    btnCodeBlur.isActivated = true
                    btnCodeBlur.text = "Скрыть код"
                    noBlur()
                }
            }

            containerHistory.setOnClickListener {
                bottomSheetDialog.show(childFragmentManager, bottomSheetDialog.tag)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        MyFragment.bottomNavVisible(
            activity = (activity as BottomNavInterface),
            idLayout = R.layout.fragment_profile
        )
    }

    private fun blur(){
        with(binding) {
            val radius = tvPersonCode.textSize
            val filter = BlurMaskFilter(radius, BlurMaskFilter.Blur.NORMAL)
            tvPersonCode.paint.maskFilter = filter
            tvPersonCode.invalidate()
        }
    }
    private fun noBlur(){
        binding.tvPersonCode.paint.maskFilter = null
        binding.tvPersonCode.invalidate()
    }
}