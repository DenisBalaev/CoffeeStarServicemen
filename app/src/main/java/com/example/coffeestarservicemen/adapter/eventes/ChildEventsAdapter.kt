package com.example.coffeestarservicemen.adapter.eventes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.databinding.ItemCardHistoryEventsBinding
import com.example.coffeestarservicemen.model.ItemCardEventsModel

class ChildEventsAdapter(
    private val items:List<ItemCardEventsModel>
): RecyclerView.Adapter<ChildEventsAdapter.ItemCardCarViewHolder>() {

    class ItemCardCarViewHolder(private val binding: ItemCardHistoryEventsBinding): RecyclerView.ViewHolder(binding.root){
        fun bindView(item: ItemCardEventsModel) = with(binding) {
            ivBasic.setImageResource(item.imageBasic)
            ivStatusSignal.setImageResource(item.imageSignalStatus)
            tvNumberCar.text = item.numberCar
            tvTime.text = item.time
            tvMessage.text = item.message
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardCarViewHolder {
        return ItemCardCarViewHolder(
            ItemCardHistoryEventsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemCardCarViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

}