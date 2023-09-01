package com.example.coffeestarservicemen.adapter.card_car

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.adapter.SpinnerSortingCarAdapter
import com.example.coffeestarservicemen.databinding.ItemCardComboBoxFiltrationBinding
import com.example.coffeestarservicemen.databinding.ItemCardFiltrationBinding

class FiltrationCarAdapter(
    private val items:List<String>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_COMBO_BOX = 0
        private const val TYPE_CARD = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            TYPE_COMBO_BOX
        } else {
            TYPE_CARD
        }
    }

    class ItemFiltrationCardViewHolder(private val binding: ItemCardFiltrationBinding): RecyclerView.ViewHolder(binding.root){
        fun bindView(item:String) {
            binding.tvNamFilter.text = item
        }
    }

    class ItemFiltrationComboBoxViewHolder(private val binding: ItemCardComboBoxFiltrationBinding): RecyclerView.ViewHolder(binding.root){
        private val listSpinner = listOf("Все", "Онлайн", "Офлайн")

        fun bindView()= with(binding){
            spinnerFiltration.apply {
                adapter = SpinnerSortingCarAdapter(itemView.context, R.layout.item_spinner_title_card_filtration, listSpinner).apply {
                    setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                }
                setSelection(0)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_CARD) {
            ItemFiltrationCardViewHolder(
                ItemCardFiltrationBinding.inflate(LayoutInflater.from(parent.context),parent, false)
            )
        }else {
            ItemFiltrationComboBoxViewHolder(
                ItemCardComboBoxFiltrationBinding.inflate(LayoutInflater.from(parent.context),parent, false)
            )
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ItemFiltrationCardViewHolder) {
            holder.bindView(items[position])
        }else if (holder is ItemFiltrationComboBoxViewHolder){
            holder.bindView()
        }
    }

    override fun getItemCount(): Int = items.size

}