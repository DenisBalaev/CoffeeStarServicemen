package com.example.coffeestarservicemen.adapter.card_car

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.databinding.ItemCardErrorBinding

class ErrorAdapter(
    private var items:List<String>
): RecyclerView.Adapter<ErrorAdapter.ItemCardCarViewHolder>() {

    private var isUpdatingSetData = false
    var isUpdating = false

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

        if (isUpdatingSetData){
            isUpdating = true
        }
    }

    override fun getItemCount(): Int = items.size

    fun setData(newList:List<String>){
        val diffUtil = DiffCallbackError(items,newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        items = newList
        diffResult.dispatchUpdatesTo(this)
        isUpdatingSetData = true
    }

}

class DiffCallbackError(
    private val oldList:List<String>,
    private val newList:List<String>
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