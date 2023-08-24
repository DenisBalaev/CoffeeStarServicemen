package com.example.coffeestarservicemen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeestarservicemen.adapter.HistoryEventsAdapter
import com.example.coffeestarservicemen.databinding.FragmentEventsBinding
import com.example.coffeestarservicemen.decoration.CustomItemDecorationHistoryEvents
import com.example.coffeestarservicemen.model.ItemHistoryEvents


class EventsFragment : Fragment() {
    private lateinit var binding: FragmentEventsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val list = mutableListOf<ItemHistoryEvents>(
            ItemHistoryEvents(
                date = "Сегодня",
                time = "15:03",
                imageBasic = R.drawable.ic_basic_2,
                imageSignalStatus = R.drawable.ic_signal_online,
                numberCar = "b952 0029",
                message = "Скоро закончится сухое молоко"
            ),
            ItemHistoryEvents(
                date = "Сегодня",
                time = "14:22",
                imageBasic = R.drawable.ic_basic_3,
                imageSignalStatus = R.drawable.ic_signal_online,
                numberCar = "b952 0029",
                message = "Скоро закончится вода"
            ),
            ItemHistoryEvents(
                date = "Вчера",
                time = "18:22",
                imageBasic = R.drawable.ic_basic_error,
                imageSignalStatus = R.drawable.ic_signal_online,
                numberCar = "b952 0029",
                message = "Drop lid error"
            ),
            ItemHistoryEvents(
                date = "Вчера",
                time = "11:22",
                imageBasic = R.drawable.ic_basic_error,
                imageSignalStatus = R.drawable.ic_signal_online,
                numberCar = "b952 0029",
                message = "Drop lid error"
            ),
            ItemHistoryEvents(
                date = "10.05.2023",
                time = "18:22",
                imageBasic = R.drawable.ic_basic_error,
                imageSignalStatus = R.drawable.ic_signal_online,
                numberCar = "b952 0029",
                message = "Drop lid error"
            ),
            ItemHistoryEvents(
                date = "10.05.2023",
                time = "11:22",
                imageBasic = R.drawable.ic_basic_error,
                imageSignalStatus = R.drawable.ic_signal_online,
                numberCar = "b952 0029",
                message = "Drop lid error"
            ),
            ItemHistoryEvents(
                date = "11.05.2023",
                time = "18:22",
                imageBasic = R.drawable.ic_basic_error,
                imageSignalStatus = R.drawable.ic_signal_online,
                numberCar = "b952 0029",
                message = "Drop lid error"
            ),
            ItemHistoryEvents(
                date = "11.05.2023",
                time = "11:22",
                imageBasic = R.drawable.ic_basic_error,
                imageSignalStatus = R.drawable.ic_signal_online,
                numberCar = "b952 0029",
                message = "Drop lid error"
            )
        )

        val space = resources.getDimensionPixelSize(R.dimen.marginTop_recyclerView_HistoryEvents)
        binding.rvHistory.apply {
            addItemDecoration(CustomItemDecorationHistoryEvents(space))
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = HistoryEventsAdapter(items = list)
        }
    }
}