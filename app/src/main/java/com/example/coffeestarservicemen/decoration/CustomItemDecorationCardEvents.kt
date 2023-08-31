package com.example.coffeestarservicemen.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.adapter.eventes.HistoryEventsAdapter

class CustomItemDecorationCardEvents(private val space: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildLayoutPosition(view)
        outRect.top = if (position != 0) space else 0
        outRect.bottom = if (position == state.itemCount - 1) space else 0
    }
}