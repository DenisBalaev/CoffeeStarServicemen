package com.example.coffeestarservicemen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.model.ItemsHistoryCode

class HistoryCodeAdapter(
    private val items:List<ItemsHistoryCode>
):RecyclerView.Adapter<HistoryCodeAdapter.ItemMainMenuViewHolder>() {

    class ItemMainMenuViewHolder(view: View):RecyclerView.ViewHolder(view){

        private val date = view.findViewById<TextView>(R.id.tv_date)
        private val code = view.findViewById<TextView>(R.id.tv_code)

        fun bindView(item:ItemsHistoryCode){
            date.text = item.date
            code.text = item.code
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemMainMenuViewHolder {
        return ItemMainMenuViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_history_code_bottom_sheet, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemMainMenuViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

}