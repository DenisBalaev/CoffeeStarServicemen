package com.example.coffeestarservicemen.adapter.eventes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.databinding.ItemRecyclerviewEventesBinding
import com.example.coffeestarservicemen.decoration.CustomItemDecorationCardEvents
import com.example.coffeestarservicemen.model.*

class HistoryEventsAdapter (
    private val items: List<ItemEventsModel>
) : RecyclerView.Adapter<HistoryEventsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRecyclerviewEventesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item = items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(private val binding: ItemRecyclerviewEventesBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.rvListEvent.apply {
                addItemDecoration(CustomItemDecorationCardEvents(resources.getDimensionPixelSize(R.dimen.marginTop_recyclerView_HistoryEvents)))
                layoutManager = LinearLayoutManager(itemView.context)
            }
        }

        fun bind(item: ItemEventsModel)= with(binding) {
            tvHeader.text = item.date
            rvListEvent.adapter = ListEventsAdapter(items = item.listCard)
        }
    }
}