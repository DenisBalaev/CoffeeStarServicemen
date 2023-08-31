package com.example.coffeestarservicemen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.model.*

class HistoryEventsAdapter (
    private val items: List<ItemHistoryEventsModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_CARD = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is ItemHistoryHeaderEventsModel) {
            TYPE_HEADER
        } else {
            TYPE_CARD
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_HEADER) {
            HeaderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_card_header_history_events, parent, false))
        } else {
            CardViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_card_history_events, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if (holder is HeaderViewHolder && item is ItemHistoryHeaderEventsModel) {
            holder.bind(item)
        } else if (holder is CardViewHolder && item is ItemHistoryCardEventsModel) {
            holder.bind(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val header = view.findViewById<TextView>(R.id.tv_header)

        fun bind(item: ItemHistoryHeaderEventsModel) {
            header.text = item.date
        }
    }

    class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageBasic = view.findViewById<ImageView>(R.id.iv_basic)
        private val imageStatusSignal = view.findViewById<ImageView>(R.id.iv_StatusSignal)
        private val numberCar = view.findViewById<TextView>(R.id.tv_numberCar)
        private val time = view.findViewById<TextView>(R.id.tv_time)
        private val message = view.findViewById<TextView>(R.id.tv_message)

        fun bind(item: ItemHistoryCardEventsModel) {
            imageBasic.setImageResource(item.imageBasic)
            imageStatusSignal.setImageResource(item.imageSignalStatus)
            numberCar.text = item.numberCar
            time.text = item.time
            message.text = item.message
        }
    }
}