package com.example.coffeestarservicemen.fragment.car_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.adapter.eventes.HistoryEventsAdapter
import com.example.coffeestarservicemen.databinding.FragmentCarScreenHistoryBinding
import com.example.coffeestarservicemen.decoration.CustomItemDecorationHistoryEvents
import com.example.coffeestarservicemen.model.ItemHistoryCardEventsModel
import com.example.coffeestarservicemen.model.ItemHistoryEventsModel
import com.example.coffeestarservicemen.model.ItemHistoryHeaderEventsModel

class CarScreenHistoryFragment : Fragment(R.layout.fragment_car_screen_history) {
    private val binding by viewBinding(FragmentCarScreenHistoryBinding::bind)

    private val list = mutableListOf<ItemHistoryEventsModel>(
        ItemHistoryHeaderEventsModel(
            date = "Сегодня",
        ),
        ItemHistoryCardEventsModel(
            time = "15:03",
            imageBasic = R.drawable.ic_basic_2,
            imageSignalStatus = R.drawable.ic_signal_online,
            numberCar = "b952 0029",
            message = "Скоро закончится сухое молоко"
        ),
        ItemHistoryCardEventsModel(
            time = "14:22",
            imageBasic = R.drawable.ic_basic_3,
            imageSignalStatus = R.drawable.ic_signal_online,
            numberCar = "b952 0029",
            message = "Скоро закончится вода"
        ),
        ItemHistoryHeaderEventsModel(date = "Вчера",),
        ItemHistoryCardEventsModel(
            time = "18:22",
            imageBasic = R.drawable.ic_basic_error,
            imageSignalStatus = R.drawable.ic_signal_online,
            numberCar = "b952 0029",
            message = "Drop lid error"
        ),
        ItemHistoryCardEventsModel(
            time = "11:22",
            imageBasic = R.drawable.ic_basic_error,
            imageSignalStatus = R.drawable.ic_signal_online,
            numberCar = "b952 0029",
            message = "Drop lid error"
        ),
        ItemHistoryHeaderEventsModel(date = "10.05.2023"),
        ItemHistoryCardEventsModel(
            time = "18:22",
            imageBasic = R.drawable.ic_basic_error,
            imageSignalStatus = R.drawable.ic_signal_online,
            numberCar = "b952 0029",
            message = "Drop lid error"
        ),
        ItemHistoryCardEventsModel(
            time = "11:22",
            imageBasic = R.drawable.ic_basic_error,
            imageSignalStatus = R.drawable.ic_signal_online,
            numberCar = "b952 0029",
            message = "Drop lid error"
        ),
        ItemHistoryHeaderEventsModel(date = "11.05.2023"),
        ItemHistoryCardEventsModel(
            time = "18:22",
            imageBasic = R.drawable.ic_basic_error,
            imageSignalStatus = R.drawable.ic_signal_online,
            numberCar = "b952 0029",
            message = "Drop lid error"
        ),
        ItemHistoryCardEventsModel(
            time = "11:22",
            imageBasic = R.drawable.ic_basic_error,
            imageSignalStatus = R.drawable.ic_signal_online,
            numberCar = "b952 0029",
            message = "Drop lid error"
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val space = resources.getDimensionPixelSize(R.dimen.marginTop_recyclerView_HistoryEvents)
        binding.rvHistoryCarScreen.apply {
            addItemDecoration(CustomItemDecorationHistoryEvents(space))
            layoutManager = LinearLayoutManager(requireContext())
            adapter = HistoryEventsAdapter(items = list)
        }
    }
}