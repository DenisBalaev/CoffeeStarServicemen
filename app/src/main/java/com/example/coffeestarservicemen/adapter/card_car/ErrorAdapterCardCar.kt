package com.example.coffeestarservicemen.adapter.card_car

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.databinding.ItemCardCarErrorBinding
import com.example.coffeestarservicemen.databinding.ItemFillingCardCarsBinding

class ErrorAdapterCardCar(
    private val items:List<String>
): RecyclerView.Adapter<ErrorAdapterCardCar.ItemCardCarViewHolder>() {

    class ItemCardCarViewHolder(private val binding: ItemCardCarErrorBinding): RecyclerView.ViewHolder(binding.root){
        fun bindView(item: String){
            binding.tvError.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardCarViewHolder {
        return ItemCardCarViewHolder(
            ItemCardCarErrorBinding.inflate( LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemCardCarViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

}