package com.example.coffeestarservicemen.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.coffeestarservicemen.R


class SpinnerSortingCarAdapter(
    context: Context,
    private val mResource: Int,
    private val items: List<String>
) : ArrayAdapter<String?>(context, mResource, items) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(parent.context).inflate(mResource, parent, false)
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        tvTitle.text = items[position]
        return view
    }
}