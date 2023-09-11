package com.example.coffeestarservicemen.adapter.car_screen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.databinding.ItemBottomSheetCommandFiltrtionBinding

class FiltrationBottomSheetAdapter(
    private val items:List<String>,
    private var listener:(String)-> Unit
):RecyclerView.Adapter<FiltrationBottomSheetAdapter.ViewHolder>() {

    var selectedPosition = 1

    class ViewHolder(val binding: ItemBottomSheetCommandFiltrtionBinding):RecyclerView.ViewHolder(binding.root){

        var bindingLayout = binding

        fun bindView(item:String){
            binding.textFiltration.text= item
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
        holder.bindingLayout.textFiltration.isActivated = position == selectedPosition
        holder.itemView.setOnClickListener {
            selectedPosition = position
            notifyDataSetChanged()
            listener(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}