package com.example.coffeestarservicemen.adapter.card_car

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.adapter.SpinnerFilterCarAdapter
import com.example.coffeestarservicemen.databinding.ItemCardComboBoxFiltrationBinding
import com.example.coffeestarservicemen.databinding.ItemCardFiltrationBinding
import com.example.coffeestarservicemen.model.ItemFilterCar

class FiltrationCarAdapter(
    private var items:MutableList<ItemFilterCar>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_SPINNER = 0
        private const val TYPE_CARD = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is ItemFilterCar.ItemComboBox) {
            TYPE_SPINNER
        } else {
            TYPE_CARD
        }
    }

    class ItemFiltrationCardViewHolder(private val binding: ItemCardFiltrationBinding): RecyclerView.ViewHolder(binding.root){
        fun bindView(item:ItemFilterCar.ItemText) {
            binding.tvNamFilter.apply {
                text = item.name
                isActivated = item.isActivity
            }
            binding.cardFiltration.isActivated = item.isActivity
        }
    }

    class ItemFiltrationSpinnerViewHolder(private val binding: ItemCardComboBoxFiltrationBinding): RecyclerView.ViewHolder(binding.root){

        fun bindView(item:ItemFilterCar.ItemComboBox)= with(binding){
            spinnerFiltration.apply {
                adapter = SpinnerFilterCarAdapter(itemView.context, R.layout.item_spinner_title_card_filtration, item.listFiltrationComboBox).apply {
                    setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_CARD) {
            ItemFiltrationCardViewHolder(
                ItemCardFiltrationBinding.inflate(LayoutInflater.from(parent.context),parent, false)
            )
        }else {
            ItemFiltrationSpinnerViewHolder(
                ItemCardComboBoxFiltrationBinding.inflate(LayoutInflater.from(parent.context),parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ItemFiltrationCardViewHolder) {
            val item = items[position] as ItemFilterCar.ItemText
            holder.bindView(item)
            holder.itemView.setOnClickListener {
                items[position] = item.apply { isActivity = !item.isActivity }
                notifyItemChanged(position)
            }
        }else if (holder is ItemFiltrationSpinnerViewHolder){
            holder.bindView(items[position] as ItemFilterCar.ItemComboBox)
        }
    }

    override fun getItemCount(): Int = items.size
}