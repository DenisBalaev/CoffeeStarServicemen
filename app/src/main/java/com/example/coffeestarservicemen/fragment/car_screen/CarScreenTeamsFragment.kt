package com.example.coffeestarservicemen.fragment.car_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.adapter.car_screen.FiltrationBottomSheetAdapter
import com.example.coffeestarservicemen.adapter.car_screen.command.CommandAdapter
import com.example.coffeestarservicemen.bottomsheet.ActionCommandGeneralBottomSheetFragment
import com.example.coffeestarservicemen.databinding.FragmentCarScreenTeamsBinding
import com.example.coffeestarservicemen.decoration.CustomItemDecorationFiltrationBottomSheet
import com.example.coffeestarservicemen.model.ItemCommand
import com.example.coffeestarservicemen.model.ItemFilter
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent


class CarScreenTeamsFragment : Fragment(R.layout.fragment_car_screen_teams) {
    private val binding by viewBinding(FragmentCarScreenTeamsBinding::bind)
    private val listFiltration = mutableListOf<ItemFilter.ItemText>(
        ItemFilter.ItemText(name = "Все"),
        ItemFilter.ItemText(name = "Чашки и крышки" , isActivity = true),
        ItemFilter.ItemText(name = "Продукты"),
        ItemFilter.ItemText(name = "Дверь"),
        ItemFilter.ItemText(name = "Продажа"),
        ItemFilter.ItemText(name = "Лед"),
        ItemFilter.ItemText(name = "Другое"),
        ItemFilter.ItemText(name = "Чистка и тюнинг")
    )
    private val listCommand = mutableListOf<ItemCommand>(
        ItemCommand(
            title = "Чашки и крышки",
            listCommand = listOf(
                "Откидные чашки", "Откидные крышки", "Главная страница", "Прогресс", "Освобождение откидной чашки",
                "Перемещение пустой чашки вперед", "Дистанционное опускание чашки", "Проверка сальника"
            )
        ),
        ItemCommand(
            title = "Продукты",
            listCommand = listOf(
                "Тест канистры 1", "Тест канистры 2", "Тест канистры 4", "Тест канистры 5", "Тест измельчителя 1", "Тест измельчителя 2",
                "Сироп 2 тест", "Сироп 3 тест", "Вода 2", "Вода 3", "Пресная вода"
            )
        ),
        ItemCommand(
            title = "Дверь",
            listCommand = listOf("Закрыть/открыть дверь", "Проверка маленькой двери")
        ),
        ItemCommand(
            title = "Продажа",
            listCommand = listOf("Запрет запуска", "Запрет закрытия")
        ),
        ItemCommand(
            title = "Лед",
            listCommand = listOf(
                "Дистанционное размораживание", "Снять ограничение на маркер льда", "Снять ограничение на продажу ледяных напитков",
                "Пустой лед", "Тест льда", "Ограничение на напитки со льдом", "Перемешивание льда", "Разблокировать маркер размораживания льда",
                "Температура обратного трубопровода равна слишком высоко, чтобы разблокировать"
            )
        ),
        ItemCommand(
            title = "Другое",
            listCommand = listOf("Получить информацию о товаре", "Водопроводная вода")
        ),
        ItemCommand(
            title = "Чистка и тюнинг",
            listCommand = listOf(
                "Очистить", "Очистить смеситель", "Очистить пивоварню", "Очистить насос для сиропа", "Опорожнение патрубка",
                "Выпуск патрубка для сиропа", "Очистка сиропа"
            )
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val linearLayoutManagerCommand = LinearLayoutManager(requireContext())
        with(binding){
            search.etSearch.hint = "Команда машине"
            rvFiltration.apply {
                layoutManager = FlexboxLayoutManager(requireContext()).apply {
                    flexWrap = FlexWrap.WRAP
                    flexDirection = FlexDirection.ROW
                    justifyContent = JustifyContent.FLEX_START
                }
                adapter = FiltrationBottomSheetAdapter(items = listFiltration){itemFilter->
                    if (itemFilter != "All") {
                        val position = listCommand.indices.find { listCommand[it].title == itemFilter }
                        position?.let { linearLayoutManagerCommand.scrollToPositionWithOffset(it,0) }
                    }else{
                        linearLayoutManagerCommand.scrollToPositionWithOffset(0,0)
                    }
                }
                addItemDecoration(
                    CustomItemDecorationFiltrationBottomSheet(
                        spaceTop = resources.getDimensionPixelSize(R.dimen.marginTop_recyclerView_Filtration_BottomSheet),
                        spaceRight = resources.getDimensionPixelSize(R.dimen.marginEnd_recyclerView_Filtration_BottomSheet)
                    )
                )
                itemAnimator = null
            }

            val bottomSheetGeneral = ActionCommandGeneralBottomSheetFragment(requireContext(),layoutInflater)
            rvCommand.apply {
                layoutManager = linearLayoutManagerCommand
                adapter = CommandAdapter(items = listCommand){
                    bottomSheetGeneral.show(it)
                }
            }
        }
    }
}