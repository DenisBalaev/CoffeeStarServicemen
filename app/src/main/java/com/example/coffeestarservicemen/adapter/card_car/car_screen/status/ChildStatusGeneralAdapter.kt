package com.example.coffeestarservicemen.adapter.card_car.car_screen.status

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.databinding.ItemCardStatusActiveBinding
import com.example.coffeestarservicemen.databinding.ItemCardStatusNoActiveBinding
import com.example.coffeestarservicemen.model.ItemCardStatusModel

class ChildStatusGeneralAdapter(
    private val items: List<ItemCardStatusModel>
):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        val TYPE_ACTIVE = 0
        val TYPE_NO_ACTIVE = 1
    }

    class ViewHolderActive(private val binding: ItemCardStatusActiveBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindViewActive(item: ItemCardStatusModel, position: Int)= with(binding){
            ivIcon.setImageResource(item.image)
            tvNumber.text = "${position + 1}"
            tvName.text = item.name
            tvPercent.text = "≈ ${item.percent}%"
        }
    }

    class ViewHolderNoActive(private val binding: ItemCardStatusNoActiveBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindViewNoActive(item: ItemCardStatusModel, position: Int)= with(binding){
            ivIcon.setImageResource(item.image)
            tvNumber.text = "${position + 1}"
            tvName.text = item.name
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].isActive){
            TYPE_ACTIVE
        }else{
            TYPE_NO_ACTIVE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_ACTIVE) {
            ViewHolderActive(
                ItemCardStatusActiveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }else{
            ViewHolderNoActive(
                ItemCardStatusNoActiveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ViewHolderActive->{holder.bindViewActive(items[position], position)}
            is ViewHolderNoActive->{holder.bindViewNoActive(items[position], position)}
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}