package com.example.coffeestarservicemen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.databinding.FragmentCarsBinding


class CarsFragment : Fragment(R.layout.fragment_cars) {

    private val binding by viewBinding(FragmentCarsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val countries = arrayOf("Сначала ближайшие", "Сначала дальние", "Колумбия", "Чили", "Уругвай")
        val spinner: Spinner = binding.spinner
        val adapter = ArrayAdapter<Any?>(requireContext(), R.layout.item_spinner_title, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.setSelection(0)
    }

}