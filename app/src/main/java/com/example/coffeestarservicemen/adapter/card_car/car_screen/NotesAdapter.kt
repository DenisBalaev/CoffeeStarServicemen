package com.example.coffeestarservicemen.adapter.card_car.car_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.R

class NotesAdapter(
    private val items:List<String>
): RecyclerView.Adapter<NotesAdapter.ItemCardNoteViewHolder>() {

    class ItemCardNoteViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val textNote = view.findViewById<TextView>(R.id.tv_text_note)

        fun bindView(item: String){
            textNote.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardNoteViewHolder {
        return ItemCardNoteViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_card_note, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemCardNoteViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

}