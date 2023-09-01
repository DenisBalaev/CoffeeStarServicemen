package com.example.coffeestarservicemen.adapter.card_car

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.databinding.ItemCardCarBinding
import com.example.coffeestarservicemen.decoration.CustomItemDecorationBottom
import com.example.coffeestarservicemen.decoration.CustomItemDecorationLeft
import com.example.coffeestarservicemen.model.ItemCarModel

class CarsAdapter(
    private val items:List<ItemCarModel>,
    private val listener:(ItemCarModel)->Unit
): RecyclerView.Adapter<CarsAdapter.ItemCardCarViewHolder>() {

    class ItemCardCarViewHolder(private val binding: ItemCardCarBinding): RecyclerView.ViewHolder(binding.root){
        init {
            binding.rvInformationFillingCar.apply {
                addItemDecoration(CustomItemDecorationBottom(resources.getDimensionPixelSize(R.dimen.marginBottom_recyclerView_Filling_Cad_Car)))
                layoutManager = LinearLayoutManager(itemView.context)
            }

            binding.rvInformationErrorCar.apply {
                addItemDecoration(CustomItemDecorationLeft(resources.getDimensionPixelSize(R.dimen.marginStart_recyclerView_Error_Cad_Car)))
                layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL,false)
            }
        }

        fun bindView(item: ItemCarModel,position: Int, listener: (ItemCarModel) -> Unit)= with(binding){
            ivStatusSignal.setImageResource(item.imageSignalStatus)
            tvNumberCar.text = item.numberCar

            if (item.listFilling.isEmpty()) {
                rvInformationFillingCar.visibility = View.GONE
            }else{
                tvBriefStatusCar.visibility = View.GONE
                rvInformationFillingCar.adapter = FillingCardCarAdapter(item.listFilling)
            }

            if (item.listError.isEmpty()) {
                rvInformationErrorCar.visibility = View.GONE
            }else{
                tvBriefStatusCar.visibility = View.GONE
                rvInformationErrorCar.adapter = ErrorAdapter(items = item.listError)
            }

            card.tvAddress.text = item.address
            card.tvDistance.text = item.distance

            if (position == 0) {
                containerDiscovery.visibility = View.VISIBLE
                tvTimeOpening.text = "Открыта с ${item.time}"
            }

            itemView.setOnClickListener {
                listener(item)
            }

            cardCar.setOnClickListener {
                listener(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardCarViewHolder {
        return ItemCardCarViewHolder(
            ItemCardCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemCardCarViewHolder, position: Int) {
        holder.bindView(items[position],position,listener)
    }

    override fun getItemCount(): Int = items.size

}