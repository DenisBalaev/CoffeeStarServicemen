package com.example.coffeestarservicemen.adapter.eventes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.decoration.CustomItemDecorationCardEvents
import com.example.coffeestarservicemen.model.*

class HistoryEventsAdapter (
    private val items: List<ItemEventsModel>,
    private val spaceTopCard:Int
) : RecyclerView.Adapter<HistoryEventsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview_eventes, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item = items[position], spaceTopCard)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvHeader = view.findViewById<TextView>(R.id.tv_header)
        private val recyclerView = view.findViewById<RecyclerView>(R.id.rv_list_event)

        fun bind(item: ItemEventsModel, spaceTopCard: Int) {
            tvHeader.text = item.date

            recyclerView.apply {
                addItemDecoration(CustomItemDecorationCardEvents(spaceTopCard))
                layoutManager = LinearLayoutManager(itemView.context)
                adapter = ListEventsAdapter(items = item.listCard)
            }
        }
    }
}