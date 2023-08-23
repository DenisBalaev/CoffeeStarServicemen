package com.example.coffeestarservicemen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeestarservicemen.adapter.HistoryAdapter
import com.example.coffeestarservicemen.databinding.FragmentCarsBinding
import com.example.coffeestarservicemen.databinding.FragmentEventsBinding
import com.example.coffeestarservicemen.model.ItemHistory


class EventsFragment : Fragment() {
    private lateinit var binding: FragmentEventsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val list = mutableListOf<ItemHistory>(
            ItemHistory(
                date = "Сегодня",
                time = "15:03",
                imageBasic = R.drawable.ic_basic_2,
                imageSignalStatus = R.drawable.ic_signal_online,
                numberCar = "b952 0029",
                message = "Скоро закончится сухое молоко"
            ),
            ItemHistory(
                date = "Сегодня",
                time = "14:22",
                imageBasic = R.drawable.ic_basic_3,
                imageSignalStatus = R.drawable.ic_signal_online,
                numberCar = "b952 0029",
                message = "Скоро закончится вода"
            ),
            ItemHistory(
                isHeader = false,
                date = "Вчера",
                time = "11:22",
                imageBasic = R.drawable.ic_basic_error,
                imageSignalStatus = R.drawable.ic_signal_online,
                numberCar = "b952 0029",
                message = "Drop lid error"
            )
        )

        binding.rvHistory.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = HistoryAdapter(items = list)
        }
    }
}