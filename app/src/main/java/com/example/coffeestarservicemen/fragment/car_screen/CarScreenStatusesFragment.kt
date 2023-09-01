package com.example.coffeestarservicemen.fragment.car_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.adapter.car_screen.status.StatusAdapter
import com.example.coffeestarservicemen.databinding.FragmentCarScreenStatusesBinding
import com.example.coffeestarservicemen.model.*

class CarScreenStatusesFragment : Fragment(R.layout.fragment_car_screen_statuses) {
    private val binding by viewBinding(FragmentCarScreenStatusesBinding::bind)

    private val list = mutableListOf(
        ItemStatusMainModel(
            listError = ListError(
                title = "Ошибки",
                listOf(
                    "Slideway №4 error","Drop lid error","Drop and Drop", "Drop lid error",
                    "Slideway №4 error","Drop lid error","Drop and Drop", "Drop lid error",
                    "Slideway №4 error","Drop lid error","Drop and Drop", "Drop lid error"
                )
            ),
            listGeneral = listOf(
                ListItemGeneralStatusModel(
                    title = "Малые канистры",
                    listCardGeneralStatus = listOf(
                        ItemCardStatusModel(
                            image = R.drawable.ic_canister_max,
                            name = "Сухое молоко",
                            percent = 96
                        ),
                        ItemCardStatusModel(
                            image = R.drawable.ic_canister_filling_medium,
                            name = "Сахар",
                            percent = 42
                        ),
                        ItemCardStatusModel(
                            image = R.drawable.ic_canister_empty,
                            name = "Не используется",
                            percent = 0,
                            isActive = false
                        ),
                        ItemCardStatusModel(
                            image = R.drawable.ic_canister_max,
                            name = "Сливки",
                            percent = 89
                        ),
                        ItemCardStatusModel(
                            image = R.drawable.ic_canister_filling_medium,
                            name = "Чай-латте",
                            percent = 12
                        ),
                        ItemCardStatusModel(
                            image = R.drawable.ic_canister_max,
                            name = "Шоколад",
                            percent = 84
                        )
                    )
                ),
                ListItemGeneralStatusModel(
                    title = "Большие канистры",
                    listCardGeneralStatus = listOf(
                        ItemCardStatusModel(
                            image = R.drawable.ic_canister_filling_medium,
                            name = "Кофейные бобы",
                            percent = 39
                        ),
                        ItemCardStatusModel(
                            image = R.drawable.ic_canister_empty,
                            name = "Пустая канистра",
                            percent = 0,
                            isActive = false
                        )
                    )
                ),
                ListItemGeneralStatusModel(
                    title = "Бутыли",
                    listCardGeneralStatus = listOf(
                        ItemCardStatusModel(
                            image = R.drawable.ic_canister_max,
                            name = "Вода",
                            percent = 23
                        ),
                        ItemCardStatusModel(
                            image = R.drawable.ic_canister_empty,
                            name = "Не подключен",
                            percent = 0,
                            isActive = false
                        ),
                        ItemCardStatusModel(
                            image = R.drawable.ic_canister_empty,
                            name = "Не подключен",
                            percent = 0,
                            isActive = false
                        ),
                        ItemCardStatusModel(
                            image = R.drawable.ic_canister_empty,
                            name = "Не подключен",
                            percent = 0,
                            isActive = false
                        )
                    )
                ),
                ListItemGeneralStatusModel(
                    title = "Сиропы",
                    listCardGeneralStatus = listOf(
                        ItemCardStatusModel(
                            image = R.drawable.ic_canister_max,
                            name = "Ванильный",
                            percent = 23
                        ),
                        ItemCardStatusModel(
                            image = R.drawable.ic_canister_max,
                            name = "Карамельный",
                            percent = 23
                        ),
                        ItemCardStatusModel(
                            image = R.drawable.ic_canister_max,
                            name = "Малиновый",
                            percent = 23
                        ),
                        ItemCardStatusModel(
                            image = R.drawable.ic_canister_basic_2,
                            name = "Не подключен",
                            percent = 0,
                            isActive = false
                        )
                    )
                ),
                ListItemGeneralStatusModel(
                    title = "Посуда",
                    listCardGeneralStatus = listOf(
                        ItemCardStatusModel(
                            image = R.drawable.ic_canister_max,
                            name = "Стаканы",
                            percent = 23
                        ),
                        ItemCardStatusModel(
                            image = R.drawable.ic_canister_max,
                            name = "Крышки",
                            percent = 23
                        )
                    )
                )
            )
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val lisError = list[0].listError
        val listGeneral = list[0].listGeneral

        val listNew = mutableListOf<StatusInterface>()
        listNew.add(lisError)
        listNew.addAll(listGeneral)

        binding.rvStatus.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = StatusAdapter(listNew)
        }
    }
}