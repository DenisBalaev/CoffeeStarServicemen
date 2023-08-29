package com.example.coffeestarservicemen.adapter.card_car

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.model.ItemFilling

class ErrorAdapterCardCar(
    private val items:List<String>
): RecyclerView.Adapter<ErrorAdapterCardCar.ItemCardCarViewHolder>() {

    class ItemCardCarViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val tvError = view.findViewById<TextView>(R.id.tv_error)

        fun bindView(item: String){
            tvError.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardCarViewHolder {
        return ItemCardCarViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_card_car_error, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemCardCarViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

}