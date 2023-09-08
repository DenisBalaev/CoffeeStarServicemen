package com.example.coffeestarservicemen.customview

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.cardview.widget.CardView

class CustomCardView : CardView {
    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context!!, attrs, defStyle) {}
    override fun onInterceptTouchEvent(me: MotionEvent): Boolean {
        return true
    }
}