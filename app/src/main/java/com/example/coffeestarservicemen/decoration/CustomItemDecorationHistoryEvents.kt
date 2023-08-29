package com.example.coffeestarservicemen.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.adapter.HistoryEventsAdapter

class CustomItemDecorationHistoryEvents(private val space: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val holder = parent.getChildViewHolder(view)
        outRect.top = if (holder is HistoryEventsAdapter.HeaderViewHolder) {
            0
        } else {
            space
        }
    }
}