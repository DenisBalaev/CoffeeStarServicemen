package com.example.coffeestarservicemen.fragment

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.BottomNavInterface
import com.example.coffeestarservicemen.MyFragment
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.adapter.card_car.CarsAdapter
import com.example.coffeestarservicemen.adapter.card_car.FiltrationCarAdapter
import com.example.coffeestarservicemen.adapter.SpinnerSortingCarAdapter
import com.example.coffeestarservicemen.databinding.FragmentCarsBinding
import com.example.coffeestarservicemen.decoration.CustomItemDecorationFiltrationCar
import com.example.coffeestarservicemen.model.ItemCarModel
import com.example.coffeestarservicemen.model.ItemFillingModel


class CarsFragment : Fragment(R.layout.fragment_cars) {
    private val binding by viewBinding(FragmentCarsBinding::bind)
    private val listSpinner = listOf("Сначала ближайшие", "Сначала дальние", "Рабочие", "Неисправные")
    private val listFiltration = listOf("Все","Закрыты","С ошибками","Продукты заканчиваются")
    private val listCars = mutableListOf<ItemCarModel>(
        ItemCarModel(
            imageSignalStatus = R.drawable.ic_signal_online,
            numberCar = "b952 0020",
            listFilling = listOf(
                ItemFillingModel(
                    image = R.drawable.ic_canister_filling_medium, listText = listOf("Сахар","Кофейные бобы"),
                    color = R.color.yellow_D8B431
                )
            ),
            listError = listOf(), address = "Т/Ц «Авиапарк» 0,5 км", distance = "0,5 км",
            time = "8:00"
        ),
        ItemCarModel(
            imageSignalStatus = R.drawable.ic_signal_offline,
            numberCar = "b952 0021",
            listFilling = listOf(
                ItemFillingModel(
                    image = R.drawable.ic_canister_basic_2, listText = listOf(
                        "Молоко","Матча","Какао","Горячий шоколад","Сироп из клубники","Сироп из малины"
                    ),
                    color = R.color.red_E03F36
                ),
                ItemFillingModel(
                    image = R.drawable.ic_canister_filling_medium, listText = listOf("Сахар","Кофейные бобы"),
                    color = R.color.yellow_D8B431
                )
            ),
            listError = listOf("Slideway №4 error","Drop lid error","Slideway №4 error","Slideway №4 error 2"),
            address = "Т/Ц «Авиапарк» 1,5 км", distance = "1,5 км"
        ),
        ItemCarModel(
            imageSignalStatus = R.drawable.ic_signal_offline,
            numberCar = "b952 0022",
            listFilling = listOf(),
            listError = listOf(), address = "Т/Ц «Авиапарк» 2,5 км", distance = "2,5 км"
        ),
        ItemCarModel(
            imageSignalStatus = R.drawable.ic_signal_online,
            numberCar = "b952 0023",
            listFilling = listOf(),
            listError = listOf(), address = "Т/Ц «Авиапарк» 3,5 км", distance = "3,5 км"
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val spaceRvFiltration = resources.getDimensionPixelSize(R.dimen.marginEnd_recyclerView_Filtration_Car)

        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        with(binding){
            spinnerSorting.apply {
                adapter = SpinnerSortingCarAdapter(requireContext(),
                    R.layout.item_spinner_title, listSpinner).apply {
                    setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                }
                setSelection(0)
            }

            rvFiltration.apply {
                addItemDecoration(CustomItemDecorationFiltrationCar(spaceRvFiltration))
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = FiltrationCarAdapter(items = listFiltration)
            }

            rvCars.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = CarsAdapter(items = listCars){
                    val action = CarsFragmentDirections.actionCarsFragmentToCarScreenFragment(it)
                    findNavController().navigate(action)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        MyFragment.bottomNavVisible(
            activity = (activity as BottomNavInterface),
            idLayout = R.layout.fragment_cars
        )
    }
}