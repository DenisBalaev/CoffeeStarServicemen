package com.example.coffeestarservicemen.customview

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.LinearLayout

class CustomLinearLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
):LinearLayout(context, attrs, defStyleAttr){
    override fun onInterceptTouchEvent(me: MotionEvent): Boolean {
        return true
    }
}