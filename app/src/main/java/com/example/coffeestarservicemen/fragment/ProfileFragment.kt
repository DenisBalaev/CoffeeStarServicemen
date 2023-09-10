package com.example.coffeestarservicemen.fragment

import android.animation.TimeAnimator
import android.animation.ValueAnimator
import android.graphics.BlurMaskFilter
import android.graphics.drawable.ClipDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.view.View
import androidx.core.animation.addListener
import androidx.core.content.ContextCompat
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

    private var mClipDrawable: ClipDrawable? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        blur()
        val bottomSheetDialog = HistoryCodeBottomSheetFragment()

        val layerDrawable = binding.btnCodeBlur.background as LayerDrawable
        mClipDrawable = layerDrawable.findDrawableByLayerId(R.id.clip_drawable) as ClipDrawable

        with(binding) {
            btnCodeBlur.setOnClickListener {
                btnCodeBlur.text = "Скрыть код"
                noBlur()
                animationButton()
            }

            containerHistory.setOnClickListener {
                bottomSheetDialog.show(childFragmentManager, bottomSheetDialog.tag)
            }
        }
    }

    private val animator = ValueAnimator.ofInt(0, 10000).apply {
        addUpdateListener {
            mClipDrawable!!.level = it.animatedValue as Int
        }
        addListener(
            onEnd = {
                mClipDrawable!!.level = 0
                binding.btnCodeBlur.text = "Показать код"
                blur()
            },
            onStart = {
                mClipDrawable!!.level = 0
            }
        )
        duration = 20000
    }

    private fun animationButton(){
        if (!animator!!.isRunning) {
            animator.start()
        }
    }

    override fun onStart() {
        super.onStart()
        MyFragment.bottomNavVisible(
            activity = (activity as BottomNavInterface),
            idLayout = R.layout.fragment_profile
        )
    }

    override fun onDestroy() {
        animator.cancel()
        mClipDrawable!!.level = 0
        super.onDestroy()
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