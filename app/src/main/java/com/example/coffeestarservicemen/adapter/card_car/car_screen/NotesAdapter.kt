package com.example.coffeestarservicemen.adapter.card_car.car_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.databinding.ItemCardNoteBinding

class NotesAdapter(
    private val items:List<String>
): RecyclerView.Adapter<NotesAdapter.ItemCardNoteViewHolder>() {

    class ItemCardNoteViewHolder(private val binding: ItemCardNoteBinding): RecyclerView.ViewHolder(binding.root){
        fun bindView(item: String){
            binding.tvTextNote.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardNoteViewHolder {
        return ItemCardNoteViewHolder(
            ItemCardNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemCardNoteViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

}