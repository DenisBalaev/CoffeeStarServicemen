package com.example.coffeestarservicemen.adapter.car_screen.status

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.adapter.card_car.ErrorAdapter
import com.example.coffeestarservicemen.databinding.ItemCardRecyclerviewErrorStatusBinding
import com.example.coffeestarservicemen.databinding.ItemCardRecyclerviewGeneralStatusBinding
import com.example.coffeestarservicemen.decoration.CustomItemDecorationErrorStatus
import com.example.coffeestarservicemen.model.ItemCardStatusModel
import com.example.coffeestarservicemen.model.ListError
import com.example.coffeestarservicemen.model.ListItemGeneralStatusModel
import com.example.coffeestarservicemen.model.StatusInterface
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent

class StatusAdapter(
    private val items:List<StatusInterface>,
    private val listener:(ItemCardStatusModel)->Unit
):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        val TYPE_ERROR = 0
        val TYPE_GENERATE = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is ListError){
            TYPE_ERROR
        }else{
            TYPE_GENERATE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_ERROR){
            ErrorViewHolder(
                ItemCardRecyclerviewErrorStatusBinding.inflate(LayoutInflater.from(parent.context),parent, false)
            )
        }else{
            GeneralViewHolder(
                ItemCardRecyclerviewGeneralStatusBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ErrorViewHolder->{holder.bindView((items[position] as ListError))}
            is GeneralViewHolder->{holder.bindView(items[position] as ListItemGeneralStatusModel,listener)}
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ErrorViewHolder(private val binding: ItemCardRecyclerviewErrorStatusBinding):RecyclerView.ViewHolder(binding.root){

        init {
            binding.rvError.apply {
                layoutManager = FlexboxLayoutManager(context).apply {
                    flexWrap = FlexWrap.WRAP
                    flexDirection = FlexDirection.ROW
                    justifyContent = JustifyContent.FLEX_START
                }
                addItemDecoration(
                    CustomItemDecorationErrorStatus(
                        spaceRight = resources.getDimensionPixelSize(R.dimen.marginEnd_recyclerView_Error_Status),
                        spaceTop = resources.getDimensionPixelSize(R.dimen.marginTop_recyclerView_Error_Status)
                    )
                )
            }
        }

        fun bindView(item: ListError)= with(binding){
            tvTitle.text = item.title
            rvError.adapter = ErrorAdapter(item.listError){}
        }
    }

    class GeneralViewHolder(private val binding: ItemCardRecyclerviewGeneralStatusBinding):RecyclerView.ViewHolder(binding.root){

        init {
            binding.rvGeneral.apply {
                layoutManager = LinearLayoutManager(context)
            }
        }

        fun bindView(item: ListItemGeneralStatusModel,listener: (ItemCardStatusModel) -> Unit)= with(binding){
            tvTitle.text = item.title
            rvGeneral.adapter = ChildStatusGeneralAdapter(item.listCardGeneralStatus){
                listener(it)
            }
        }
    }

}