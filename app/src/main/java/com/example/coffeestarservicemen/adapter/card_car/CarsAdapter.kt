package com.example.coffeestarservicemen.adapter.card_car

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.decoration.CustomItemDecorationBottom
import com.example.coffeestarservicemen.decoration.CustomItemDecorationLeft
import com.example.coffeestarservicemen.model.ItemCarModel

class CarsAdapter(
    private val items:List<ItemCarModel>,
    private val listener:(ItemCarModel)->Unit
): RecyclerView.Adapter<CarsAdapter.ItemCardCarViewHolder>() {

    class ItemCardCarViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val ivStatusSignal = view.findViewById<ImageView>(R.id.iv_status_signal)
        private val tvNumberCar = view.findViewById<TextView>(R.id.tv_numberCar)
        private val rvFilling = view.findViewById<RecyclerView>(R.id.rv_information_filling_car)
        private val rvError = view.findViewById<RecyclerView>(R.id.rv_information_error_car)
        private val tvBriefStatusCar = view.findViewById<TextView>(R.id.tv_brief_status_car)
        private val tvAddress = view.findViewById<TextView>(R.id.tv_address)
        private val tvDistance = view.findViewById<TextView>(R.id.tv_distance)
        private val cardCar = view.findViewById<CardView>(R.id.card_car)
        val tvTime = view.findViewById<TextView>(R.id.tv_time_opening)
        val containerDiscovery = view.findViewById<RelativeLayout>(R.id.container_discovery)

        init {
            rvFilling.apply {
                addItemDecoration(CustomItemDecorationBottom(itemView.context.resources.getDimensionPixelSize(R.dimen.marginBottom_recyclerView_Filling_Cad_Car)))
                layoutManager = LinearLayoutManager(itemView.context)
            }

            rvError.apply {
                addItemDecoration(CustomItemDecorationLeft(itemView.context.resources.getDimensionPixelSize(R.dimen.marginStart_recyclerView_Error_Cad_Car)))
                layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL,false)
            }
        }

        fun bindView(item: ItemCarModel, listener: (ItemCarModel) -> Unit){

            ivStatusSignal.setImageResource(item.imageSignalStatus)
            tvNumberCar.text = item.numberCar

            if (item.listFilling.isEmpty()) {
                rvFilling.visibility = View.GONE
            }else{
                tvBriefStatusCar.visibility = View.GONE
                rvFilling.adapter = FillingCardCarAdapter(item.listFilling)
            }

            if (item.listError.isEmpty()) {
                rvError.visibility = View.GONE
            }else{
                tvBriefStatusCar.visibility = View.GONE
                rvError.adapter = ErrorAdapterCardCar(items = item.listError)
            }

            tvAddress.text = item.address
            tvDistance.text = item.distance

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