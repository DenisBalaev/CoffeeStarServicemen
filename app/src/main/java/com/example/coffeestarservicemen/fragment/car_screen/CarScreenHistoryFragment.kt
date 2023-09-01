package com.example.coffeestarservicemen.fragment.car_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.adapter.eventes.HistoryEventsAdapter
import com.example.coffeestarservicemen.databinding.FragmentCarScreenHistoryBinding
import com.example.coffeestarservicemen.model.ItemCardEventsModel
import com.example.coffeestarservicemen.model.ItemEventsModel

class CarScreenHistoryFragment : Fragment(R.layout.fragment_car_screen_history) {
    private val binding by viewBinding(FragmentCarScreenHistoryBinding::bind)

    private val list = mutableListOf<ItemEventsModel>(
        ItemEventsModel(
            date = "Сегодня",
            listCard = listOf(
                ItemCardEventsModel(
                    time = "15:03",
                    imageBasic = R.drawable.ic_canister_basic_2,
                    imageSignalStatus = R.drawable.ic_signal_online,
                    numberCar = "b952 0029",
                    message = "Скоро закончится сухое молоко"
                ),
                ItemCardEventsModel(
                    time = "14:22",
                    imageBasic = R.drawable.ic_canister_basic_3,
                    imageSignalStatus = R.drawable.ic_signal_online,
                    numberCar = "b952 0029",
                    message = "Скоро закончится вода"
                )
            )
        ),
        ItemEventsModel(
            date = "Вчера",
            listCard = listOf(
                ItemCardEventsModel(
                    time = "18:22",
                    imageBasic = R.drawable.ic_basic_error,
                    imageSignalStatus = R.drawable.ic_signal_online,
                    numberCar = "b952 0029",
                    message = "Drop lid error"
                ),
                ItemCardEventsModel(
                    time = "11:22",
                    imageBasic = R.drawable.ic_basic_error,
                    imageSignalStatus = R.drawable.ic_signal_online,
                    numberCar = "b952 0029",
                    message = "Drop lid error"
                )
            )
        ),
        ItemEventsModel(
            date = "10.05.2023",
            listCard = listOf(
                ItemCardEventsModel(
                    time = "18:22",
                    imageBasic = R.drawable.ic_basic_error,
                    imageSignalStatus = R.drawable.ic_signal_online,
                    numberCar = "b952 0029",
                    message = "Drop lid error"
                ),
                ItemCardEventsModel(
                    time = "11:22",
                    imageBasic = R.drawable.ic_basic_error,
                    imageSignalStatus = R.drawable.ic_signal_online,
                    numberCar = "b952 0029",
                    message = "Drop lid error"
                )
            )
        ),
        ItemEventsModel(
            date = "11.05.2023",
            listCard = listOf(
                ItemCardEventsModel(
                    time = "18:22",
                    imageBasic = R.drawable.ic_basic_error,
                    imageSignalStatus = R.drawable.ic_signal_online,
                    numberCar = "b952 0029",
                    message = "Drop lid error"
                ),
                ItemCardEventsModel(
                    time = "11:22",
                    imageBasic = R.drawable.ic_basic_error,
                    imageSignalStatus = R.drawable.ic_signal_online,
                    numberCar = "b952 0029",
                    message = "Drop lid error"
                )
            )
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvHistoryCarScreen.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = HistoryEventsAdapter(
                items = list
            )
        }
    }
}