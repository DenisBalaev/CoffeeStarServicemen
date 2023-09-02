package com.example.coffeestarservicemen.adapter.card_car

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.databinding.ItemCardCarBinding
import com.example.coffeestarservicemen.decoration.CustomItemDecorationCardCar
import com.example.coffeestarservicemen.decoration.CustomItemDecorationErrorCar
import com.example.coffeestarservicemen.model.ItemCarModel

class CarsAdapter(
    private val items:List<ItemCarModel>,
    private val listener:(ItemCarModel)->Unit
): RecyclerView.Adapter<CarsAdapter.ItemCardCarViewHolder>() {

    class ItemCardCarViewHolder(private val binding: ItemCardCarBinding): RecyclerView.ViewHolder(binding.root){

        lateinit var dataList:List<String>

        init {
            binding.rvInformationFillingCar.apply {
                addItemDecoration(CustomItemDecorationCardCar(resources.getDimensionPixelSize(R.dimen.marginBottom_recyclerView_Filling_Cad_Car)))
                layoutManager = LinearLayoutManager(itemView.context)
            }

            val layoutManagerError = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL,false)
            binding.rvInformationErrorCar.apply {
                addItemDecoration(CustomItemDecorationErrorCar(resources.getDimensionPixelSize(R.dimen.marginStart_recyclerView_Error_Cad_Car)))
                layoutManager = layoutManagerError
                addOnLayoutChangeListener(object : View.OnLayoutChangeListener{
                    override fun onLayoutChange(v: View?, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) {
                        val lastVisibleItem: Int = layoutManagerError.findLastVisibleItemPosition()
                        if (lastVisibleItem > 0) {
                            val count = "+${dataList.size - lastVisibleItem}"
                            dataList = dataList.toMutableList().slice(0..lastVisibleItem).toMutableList().apply {
                                this[lastVisibleItem] = count
                            }

                            binding.rvInformationErrorCar.removeOnLayoutChangeListener(this);
                            binding.rvInformationErrorCar.apply {
                                itemAnimator = null
                                post{(this.adapter as ErrorAdapter).setData(dataList)}
                            }
                        }
                    }

                })
            }
        }

        fun bindView(item: ItemCarModel,position: Int, listener: (ItemCarModel) -> Unit)= with(binding){

            dataList = item.listError

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