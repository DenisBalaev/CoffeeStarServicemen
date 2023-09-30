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
        ItemFilter.ItemText(name = "All"),
        ItemFilter.ItemText(name = "Cup&Lid" , isActivity = true),
        ItemFilter.ItemText(name = "Products"),
        ItemFilter.ItemText(name = "Door"),
        ItemFilter.ItemText(name = "Sell"),
        ItemFilter.ItemText(name = "Ice"),
        ItemFilter.ItemText(name = "Other"),
        ItemFilter.ItemText(name = "Cleaning&Tuning")
    )
    private val listCommand = mutableListOf<ItemCommand>(
        ItemCommand(
            title = "Cup&Lid",
            listCommand = listOf(
                "Drop cups","Drop lids","Home","Progress","Drop cup release","Empty cup move forward","Remote drop cup","Gland test"
            )
        ),
        ItemCommand(
            title = "Products",
            listCommand = listOf(
                "Canister 1 test","Canister 2 test","Canister 4 test","Canister 5 test","Grinder 1 test","Grinder 2 test",
                "Syrup 2 test","Syrup 3 test","Water 2","Water 3","Fresh water"
            )
        ),
        ItemCommand(
            title = "Door",
            listCommand = listOf("Close/open door","Small door test")
        ),
        ItemCommand(
            title = "Sell",
            listCommand = listOf("Start prohibition","Close prohibition")
        ),
        ItemCommand(
            title = "Ice",
            listCommand = listOf(
                "Remote defrost","Remove the restriction of ice marker", "Remove the restriction of ice drink sales","Empty ice",
                "Ice test","Ice drink restriction","Ice stirring","Unlock the defrost of ice marker" ,"The return pipe temperature is too high to unlock"
            )
        ),
        ItemCommand(
            title = "Other",
            listCommand = listOf("Get goods information","Tap water")
        ),
        ItemCommand(
            title = "Cleaning&Tuning",
            listCommand = listOf(
                "Clean","Clean mixer","Clean brewer","Clean syrup pump","Pipe emptying","Syrop pipe exhaust","Syrup clean"
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