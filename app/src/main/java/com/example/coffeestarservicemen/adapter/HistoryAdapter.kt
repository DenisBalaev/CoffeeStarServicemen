package com.example.coffeestarservicemen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.model.ItemHistory

class HistoryAdapter (
    private val items: List<ItemHistory>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_CARD = 1
    }

    private var dateSave = "Вчера"

    override fun getItemViewType(position: Int): Int {
        return if (items[position].date != dateSave) {
            dateSave = items[position].date
            TYPE_HEADER
        } else {
            TYPE_CARD
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_HEADER) {
            HeaderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_item_header_history, parent, false))
        } else {
            CardViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_item_history, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if (holder is HeaderViewHolder) {
            holder.bind(item)
        } else if (holder is CardViewHolder) {
            holder.bind(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val header = view.findViewById<TextView>(R.id.tv_header)
        private val imageBasic = view.findViewById<ImageView>(R.id.iv_basic)
        private val imageStatusSignal = view.findViewById<ImageView>(R.id.iv_StatusSignal)
        private val numberCar = view.findViewById<TextView>(R.id.tv_numberCar)
        private val time = view.findViewById<TextView>(R.id.tv_time)
        private val message = view.findViewById<TextView>(R.id.tv_message)

        fun bind(item:ItemHistory) {
            header.text = item.date
            imageBasic.setImageResource(item.imageBasic)
            imageStatusSignal.setImageResource(item.imageSignalStatus)
            numberCar.text = item.numberCar
            time.text = item.time
            message.text = item.message
        }
    }

    class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageBasic = view.findViewById<ImageView>(R.id.iv_basic)
        private val imageStatusSignal = view.findViewById<ImageView>(R.id.iv_StatusSignal)
        private val numberCar = view.findViewById<TextView>(R.id.tv_numberCar)
        private val time = view.findViewById<TextView>(R.id.tv_time)
        private val message = view.findViewById<TextView>(R.id.tv_message)

        fun bind(item: ItemHistory) {
            imageBasic.setImageResource(item.imageBasic)
            imageStatusSignal.setImageResource(item.imageSignalStatus)
            numberCar.text = item.numberCar
            time.text = item.time
            message.text = item.message
        }
    }
}