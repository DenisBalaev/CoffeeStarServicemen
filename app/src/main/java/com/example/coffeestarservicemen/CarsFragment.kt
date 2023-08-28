package com.example.coffeestarservicemen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.adapter.SpinnerSortingCarAdapter
import com.example.coffeestarservicemen.databinding.FragmentCarsBinding


class CarsFragment : Fragment(R.layout.fragment_cars) {

    private val binding by viewBinding(FragmentCarsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val countries = listOf("Сначала ближайшие", "Сначала дальние", "Рабочие", "Неисправные")
        val adapter = SpinnerSortingCarAdapter(requireContext(), R.layout.item_spinner_title, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        with(binding){
            spinnerSorting.apply {
                this.adapter = adapter
                setSelection(0)
            }
        }

    }

}