package com.example.coffeestarservicemen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.databinding.ItemBottomSheetHistoryCodeBinding
import com.example.coffeestarservicemen.model.ItemsHistoryCodeModel

class HistoryCodeBottomSheetAdapter(
    private val items:List<ItemsHistoryCodeModel>
):RecyclerView.Adapter<HistoryCodeBottomSheetAdapter.ItemMainMenuViewHolder>() {

    class ItemMainMenuViewHolder(private val binding: ItemBottomSheetHistoryCodeBinding):RecyclerView.ViewHolder(binding.root){
        fun bindView(item:ItemsHistoryCodeModel) = with(binding){
            tvDate.text = item.date
            tvCode.text = item.code
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemMainMenuViewHolder {
        return ItemMainMenuViewHolder(
            ItemBottomSheetHistoryCodeBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemMainMenuViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

}