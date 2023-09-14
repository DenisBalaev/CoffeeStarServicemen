package com.example.coffeestarservicemen.adapter.car_screen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.databinding.ItemBottomSheetCommandFiltrtionBinding
import com.example.coffeestarservicemen.model.ItemFilter

class FiltrationBottomSheetAdapter(
    private var items:List<ItemFilter.ItemText>,
    private var listener:(String)-> Unit
):RecyclerView.Adapter<FiltrationBottomSheetAdapter.ViewHolder>() {

    var selectedPosition = 1

    class ViewHolder(val binding: ItemBottomSheetCommandFiltrtionBinding):RecyclerView.ViewHolder(binding.root){

        fun bindView(item:ItemFilter.ItemText){
            binding.textFiltration.text = item.name
            binding.textFiltration.isActivated = item.isActivity
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBottomSheetCommandFiltrtionBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(items[position])
        holder.itemView.setOnClickListener {
            items[selectedPosition].isActivity = false
            items[position].isActivity = true
            notifyItemChanged(selectedPosition)
            notifyItemChanged(position)
            selectedPosition = position
            listener(items[position].name)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(newList:List<ItemFilter.ItemText>){
        val diffUtil = DiffCallbackFiltrationCommand(items,newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        items = newList
        diffResult.dispatchUpdatesTo(this)
    }
}

class DiffCallbackFiltrationCommand(
    private val oldList:List<ItemFilter.ItemText>,
    private val newList:List<ItemFilter.ItemText>
): DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size
    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}