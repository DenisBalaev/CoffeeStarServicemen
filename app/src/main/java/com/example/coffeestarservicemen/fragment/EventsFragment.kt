package com.example.coffeestarservicemen.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.BottomNavInterface
import com.example.coffeestarservicemen.MyFragment
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.adapter.eventes.HistoryEventsAdapter
import com.example.coffeestarservicemen.databinding.FragmentEventsBinding
import com.example.coffeestarservicemen.model.*


class EventsFragment : Fragment(R.layout.fragment_events) {
    private val binding by viewBinding(FragmentEventsBinding::bind)
    private val list = mutableListOf<ItemEventsModel>(
        ItemEventsModel(
            date = "Сегодня",
            listCard = listOf(
                ItemCardEventsModel(
                    time = "15:03",
                    imageBasic = R.drawable.ic_basic_2,
                    imageSignalStatus = R.drawable.ic_signal_online,
                    numberCar = "b952 0029",
                    message = "Скоро закончится сухое молоко"
                ),
                ItemCardEventsModel(
                    time = "14:22",
                    imageBasic = R.drawable.ic_basic_3,
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
        binding.rvHistoryEvents.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = HistoryEventsAdapter(
                items = list,
                spaceTopCard = resources.getDimensionPixelSize(R.dimen.marginTop_recyclerView_HistoryEvents)
            )
        }
    }

    override fun onStart() {
        super.onStart()
        MyFragment.bottomNavVisible(
            activity = (activity as BottomNavInterface),
            idLayout = R.layout.fragment_events
        )
    }
}