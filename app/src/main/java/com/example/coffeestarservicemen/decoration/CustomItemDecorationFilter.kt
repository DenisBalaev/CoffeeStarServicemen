package com.example.coffeestarservicemen.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class CustomItemDecorationFilter(private val space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        val isLastItem = position == state.itemCount - 1

        if (!isLastItem) {
            outRect.right = space
        } else {
            outRect.right = 0
        }
    }
}