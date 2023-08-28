package com.example.coffeestarservicemen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.adapter.FiltrationAdapter
import com.example.coffeestarservicemen.adapter.SpinnerSortingCarAdapter
import com.example.coffeestarservicemen.databinding.FragmentCarsBinding
import com.example.coffeestarservicemen.decoration.CustomItemDecorationFilter
import com.example.coffeestarservicemen.decoration.CustomItemDecorationHistoryEvents


class CarsFragment : Fragment(R.layout.fragment_cars) {

    private val binding by viewBinding(FragmentCarsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val listSpinner = listOf("Сначала ближайшие", "Сначала дальние", "Рабочие", "Неисправные")
        val adapterSpinner = SpinnerSortingCarAdapter(requireContext(), R.layout.item_spinner_title, listSpinner)
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val listFiltration = listOf("Все","Закрыты","С ошибками","Продукты заканчиваются")
        val spaceRvFiltration = resources.getDimensionPixelSize(R.dimen.marginEnd_recyclerView_Filtration)

        with(binding){
            spinnerSorting.apply {
                adapter = adapterSpinner
                setSelection(0)
            }

            rvFiltration.apply {
                addItemDecoration(CustomItemDecorationFilter(spaceRvFiltration))
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = FiltrationAdapter(items = listFiltration)
            }
        }

    }

}