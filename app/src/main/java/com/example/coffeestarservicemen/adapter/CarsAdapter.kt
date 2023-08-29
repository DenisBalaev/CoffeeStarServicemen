package com.example.coffeestarservicemen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.decoration.CustomItemFillingCardCar
import com.example.coffeestarservicemen.model.ItemCar

class CarsAdapter(
    private val items:List<ItemCar>,
    private val listener:(ItemCar)->Unit
): RecyclerView.Adapter<CarsAdapter.ItemCardCarViewHolder>() {

    class ItemCardCarViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val ivStatusSignal = view.findViewById<ImageView>(R.id.iv_status_signal)
        private val tvNumberCar = view.findViewById<TextView>(R.id.tv_numberCar)
        private val rvFilling = view.findViewById<RecyclerView>(R.id.rv_information_filling_car)
        private val rvError = view.findViewById<RecyclerView>(R.id.rv_information_error_car)
        private val tvBriefStatusCar = view.findViewById<TextView>(R.id.tv_brief_status_car)
        private val tvAddress = view.findViewById<TextView>(R.id.tv_address)
        private val tvDistance = view.findViewById<TextView>(R.id.tv_distance)
        val tvTime = view.findViewById<TextView>(R.id.tv_time)
        val containerDiscovery = view.findViewById<RelativeLayout>(R.id.container_discovery)

        fun bindView(item: ItemCar, listener: (ItemCar) -> Unit){

            ivStatusSignal.setImageResource(item.imageSignalStatus)
            tvNumberCar.text = item.numberCar

            if (item.listFilling.isEmpty()) {
                rvFilling.visibility = View.GONE
            }else{
                tvBriefStatusCar.visibility = View.GONE
                rvFilling.apply {
                    addItemDecoration(CustomItemFillingCardCar(itemView.context.resources.getDimensionPixelSize(R.dimen.marginBottom_recyclerView_Filling_Cad_Car)))
                    layoutManager = LinearLayoutManager(itemView.context)
                    adapter = FillingCardCarAdapter(item.listFilling)
                }
            }

            if (item.listError.isEmpty()) {
                rvError.visibility = View.GONE
            }else{
                tvBriefStatusCar.visibility = View.GONE
            }

            tvAddress.text = item.address
            tvDistance.text = item.distance

            itemView.setOnClickListener {
                listener(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardCarViewHolder {
        return ItemCardCarViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_card_car, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemCardCarViewHolder, position: Int) {
        holder.bindView(items[position],listener)
        if (position == 0) {
            holder.containerDiscovery.visibility = View.VISIBLE
            holder.tvTime.text = "Открыта с ${items[position].time}"
        }
    }

    override fun getItemCount(): Int = items.size

}