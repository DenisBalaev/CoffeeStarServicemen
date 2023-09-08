package com.example.coffeestarservicemen.adapter.card_car

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.databinding.ItemFillingCardCarsBinding
import com.example.coffeestarservicemen.model.ItemCarModel
import com.example.coffeestarservicemen.model.ItemFillingModel

class FillingCardCarAdapter(
    private val items:List<ItemFillingModel>
): RecyclerView.Adapter<FillingCardCarAdapter.ItemCardCarViewHolder>() {

    class ItemCardCarViewHolder(private val binding: ItemFillingCardCarsBinding): RecyclerView.ViewHolder(binding.root){
        fun bindView(item: ItemFillingModel)= with(binding){
            ivFilling.setImageResource(item.image)
            tvFilling.apply {
                text = item.listText.joinToString(separator = " • ")
                setTextColor(ContextCompat.getColor(itemView.context,item.color))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardCarViewHolder {
        return ItemCardCarViewHolder(
            ItemFillingCardCarsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ItemCardCarViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

}