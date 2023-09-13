package com.example.coffeestarservicemen.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.coffeestarservicemen.databinding.ItemSpinnerTitleBinding

class SpinnerSortingCarAdapter (
    context: Context,
    private val mResource: Int,
    private val items: List<String>
) : ArrayAdapter<String?>(context, mResource, items) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = ItemSpinnerTitleBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        view.tvTitle.text = items[position]
        return view.root
    }
}