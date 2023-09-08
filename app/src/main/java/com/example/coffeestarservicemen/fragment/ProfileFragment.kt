package com.example.coffeestarservicemen.fragment

import android.animation.TimeAnimator
import android.graphics.BlurMaskFilter
import android.graphics.drawable.ClipDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.BottomNavInterface
import com.example.coffeestarservicemen.MainActivity
import com.example.coffeestarservicemen.MyFragment
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.bottomsheet.HistoryCodeBottomSheetFragment
import com.example.coffeestarservicemen.databinding.FragmentProfileBinding


class ProfileFragment : Fragment(R.layout.fragment_profile),TimeAnimator.TimeListener {
    private val binding by viewBinding(FragmentProfileBinding::bind)

    private var mAnimator: TimeAnimator? = null
    private var mCurrentLevel = 0
    private var mClipDrawable: ClipDrawable? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mAnimator = TimeAnimator()
        mAnimator!!.setTimeListener(this)
        blur()
        val bottomSheetDialog = HistoryCodeBottomSheetFragment()

        with(binding) {
            btnCodeBlur.setOnClickListener {
                btnCodeBlur.text = "Скрыть код"
                noBlur()
                val layerDrawable = binding.btnCodeBlur.background as LayerDrawable
                mClipDrawable = layerDrawable.findDrawableByLayerId(R.id.clip_drawable) as ClipDrawable
                animationButton()
            }

            containerHistory.setOnClickListener {
                bottomSheetDialog.show(childFragmentManager, bottomSheetDialog.tag)
            }
        }
    }

    override fun onTimeUpdate(animation: TimeAnimator?, totalTime: Long, deltaTime: Long) {
        mClipDrawable!!.level = mCurrentLevel
        if (mCurrentLevel >= MAX_LEVEL) {
            mAnimator!!.cancel()
            binding.btnCodeBlur.apply {
                background = ContextCompat.getDrawable(context,R.drawable.rounder_button_background_animation_profile)
                text = "Показать код"
            }
            blur()
        } else {
            mCurrentLevel = MAX_LEVEL.coerceAtMost(mCurrentLevel + LEVEL_INCREMENT)
        }
    }

    private fun animationButton(){
        if (!mAnimator!!.isRunning) {
            mCurrentLevel = 0
            mAnimator!!.start()
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

    companion object {
        private val LEVEL_INCREMENT = 100
        private val MAX_LEVEL = 10000
    }
}