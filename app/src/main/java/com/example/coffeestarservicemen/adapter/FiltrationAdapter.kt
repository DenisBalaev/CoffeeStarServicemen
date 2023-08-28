package com.example.coffeestarservicemen.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.R

class FiltrationAdapter(
    private val items:List<String>
): RecyclerView.Adapter<FiltrationAdapter.ItemFiltrationViewHolder>() {

    private var selectedPosition = 0

    class ItemFiltrationViewHolder(view: View): RecyclerView.ViewHolder(view){
        val radioButton = view.findViewById<RadioButton>(R.id.radio_button)
        private val nameFilter = view.findViewById<TextView>(R.id.tv_nam_filter)

        fun bindView(item:String) {
            nameFilter.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFiltrationViewHolder {
        return ItemFiltrationViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_card_filtration, parent, false)
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ItemFiltrationViewHolder, position: Int) {
        holder.bindView(items[position])
        holder.radioButton.isVisible = position == selectedPosition
        holder.itemView.setOnClickListener {
            selectedPosition = position
            notifyDataSetChanged()
        }

        holder.radioButton.setOnClickListener {
            selectedPosition = position
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = items.size

}