package com.example.coffeestarservicemen.adapter.eventes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.model.ItemCardEventsModel

class ListEventsAdapter(
    private val items:List<ItemCardEventsModel>
): RecyclerView.Adapter<ListEventsAdapter.ItemCardCarViewHolder>() {

    class ItemCardCarViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val imageBasic = view.findViewById<ImageView>(R.id.iv_basic)
        private val imageStatusSignal = view.findViewById<ImageView>(R.id.iv_StatusSignal)
        private val numberCar = view.findViewById<TextView>(R.id.tv_numberCar)
        private val time = view.findViewById<TextView>(R.id.tv_time)
        private val message = view.findViewById<TextView>(R.id.tv_message)

        fun bindView(item: ItemCardEventsModel) {
            imageBasic.setImageResource(item.imageBasic)
            imageStatusSignal.setImageResource(item.imageSignalStatus)
            numberCar.text = item.numberCar
            time.text = item.time
            message.text = item.message
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardCarViewHolder {
        return ItemCardCarViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_card_history_events, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemCardCarViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

}