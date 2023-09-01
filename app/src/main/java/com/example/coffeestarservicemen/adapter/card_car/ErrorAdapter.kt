package com.example.coffeestarservicemen.adapter.card_car

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.databinding.ItemCardErrorBinding

class ErrorAdapter(
    private val items:List<String>
): RecyclerView.Adapter<ErrorAdapter.ItemCardCarViewHolder>() {

    class ItemCardCarViewHolder(private val binding: ItemCardErrorBinding): RecyclerView.ViewHolder(binding.root){
        fun bindView(item: String){
            binding.tvError.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardCarViewHolder {
        return ItemCardCarViewHolder(
            ItemCardErrorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemCardCarViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

}