package com.example.coffeestarservicemen.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.LightingColorFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.databinding.ItemCardFiltrationBinding
import com.example.coffeestarservicemen.databinding.ItemSpinnerTitleCardFiltrationBinding


class SpinnerFilterCarAdapter(
    context: Context,
    private val mResource: Int,
    private val items: List<String>
) : ArrayAdapter<String?>(context, mResource, items) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = ItemSpinnerTitleCardFiltrationBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        with(view) {
            tvTitle.apply {
                text = items[position]
                isActivated = items[position] != "Все"
            }
            icon.colorFilter = if (items[position] == "Все") {
                LightingColorFilter(0, ContextCompat.getColor(context, R.color.gray_8B8B8B))
            } else {
                LightingColorFilter(0, ContextCompat.getColor(context, R.color.white))
            }

            cardCbFiltration.isActivated = items[position] != "Все"
        }
        return view.root
    }
}