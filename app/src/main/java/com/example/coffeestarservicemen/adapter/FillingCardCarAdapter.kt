package com.example.coffeestarservicemen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.model.ItemCar
import com.example.coffeestarservicemen.model.ItemFilling

class FillingCardCarAdapter(
    private val items:List<ItemFilling>
): RecyclerView.Adapter<FillingCardCarAdapter.ItemCardCarViewHolder>() {

    class ItemCardCarViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val ivFilling = view.findViewById<ImageView>(R.id.iv_filling)
        private val tvFilling = view.findViewById<TextView>(R.id.tv_filling)

        fun bindView(item: ItemFilling){
            ivFilling.setImageResource(item.image)
            tvFilling.apply {
                text = item.listText.joinToString(separator = " • ")
                setTextColor(ContextCompat.getColor(itemView.context,item.color))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardCarViewHolder {
        return ItemCardCarViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_filling_card_cars, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemCardCarViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

}