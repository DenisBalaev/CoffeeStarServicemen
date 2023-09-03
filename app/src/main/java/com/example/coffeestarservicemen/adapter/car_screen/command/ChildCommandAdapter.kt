package com.example.coffeestarservicemen.adapter.car_screen.command

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.databinding.ItemCardCommandBinding
import com.example.coffeestarservicemen.model.ItemCommand

class ChildCommandAdapter(
    private val items:List<String>,
    private val listener:(String)-> Unit
):RecyclerView.Adapter<ChildCommandAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemCardCommandBinding):RecyclerView.ViewHolder(binding.root){

        fun bindView(item:String,listener: (String) -> Unit)= with(binding){
            textCommand.text = item
            itemView.setOnClickListener {
                listener(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCardCommandBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(items[position],listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}