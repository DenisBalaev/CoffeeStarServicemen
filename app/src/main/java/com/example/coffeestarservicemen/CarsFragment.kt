package com.example.coffeestarservicemen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.adapter.card_car.CarsAdapter
import com.example.coffeestarservicemen.adapter.card_car.FiltrationCarAdapter
import com.example.coffeestarservicemen.adapter.SpinnerSortingCarAdapter
import com.example.coffeestarservicemen.databinding.FragmentCarsBinding
import com.example.coffeestarservicemen.decoration.CustomItemDecorationFilter
import com.example.coffeestarservicemen.model.ItemCar
import com.example.coffeestarservicemen.model.ItemFilling


class CarsFragment : Fragment(R.layout.fragment_cars) {
    private val binding by viewBinding(FragmentCarsBinding::bind)
    private val listSpinner = listOf("Сначала ближайшие", "Сначала дальние", "Рабочие", "Неисправные")
    private val listFiltration = listOf("Все","Закрыты","С ошибками","Продукты заканчиваются")
    private val listCars = mutableListOf<ItemCar>(
        ItemCar(
            imageSignalStatus = R.drawable.ic_signal_online,
            numberCar = "b952 0020",
            listFilling = listOf(
                ItemFilling(
                    image = R.drawable.ic_filling_medium, listText = listOf("Сахар","Кофейные бобы"),
                    color = R.color.yellow_D8B431
                )
            ),
            listError = listOf(), address = "Т/Ц «Авиапарк» 0,5 км", distance = "0,5 км",
            time = "8:00"
        ),
        ItemCar(
            imageSignalStatus = R.drawable.ic_signal_offline,
            numberCar = "b952 0021",
            listFilling = listOf(
                ItemFilling(
                    image = R.drawable.ic_basic_2, listText = listOf(
                        "Молоко","Матча","Какао","Горячий шоколад","Сироп из клубники","Сироп из малины"
                    ),
                    color = R.color.red_E03F36
                ),
                ItemFilling(
                    image = R.drawable.ic_filling_medium, listText = listOf("Сахар","Кофейные бобы"),
                    color = R.color.yellow_D8B431
                )
            ),
            listError = listOf("Slideway №4 error","Drop lid error","Slideway №4 error 1","Slideway №4 error 2"),
            address = "Т/Ц «Авиапарк» 1,5 км", distance = "1,5 км"
        ),
        ItemCar(
            imageSignalStatus = R.drawable.ic_signal_offline,
            numberCar = "b952 0022",
            listFilling = listOf(),
            listError = listOf(), address = "Т/Ц «Авиапарк» 2,5 км", distance = "2,5 км"
        ),
        ItemCar(
            imageSignalStatus = R.drawable.ic_signal_online,
            numberCar = "b952 0023",
            listFilling = listOf(),
            listError = listOf(), address = "Т/Ц «Авиапарк» 3,5 км", distance = "3,5 км"
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val spaceRvFiltration = resources.getDimensionPixelSize(R.dimen.marginEnd_recyclerView_Filtration_Car)

        with(binding){
            spinnerSorting.apply {
                adapter = SpinnerSortingCarAdapter(requireContext(), R.layout.item_spinner_title, listSpinner).apply {
                    setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                }
                setSelection(0)
            }

            rvFiltration.apply {
                addItemDecoration(CustomItemDecorationFilter(spaceRvFiltration))
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = FiltrationCarAdapter(items = listFiltration)
            }

            rvCars.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = CarsAdapter(items = listCars){
                    Toast.makeText(requireContext(),it.toString(),Toast.LENGTH_LONG).show()
                }
            }
        }

    }

}