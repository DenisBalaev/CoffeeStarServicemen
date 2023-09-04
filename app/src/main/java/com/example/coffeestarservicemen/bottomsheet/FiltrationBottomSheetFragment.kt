package com.example.coffeestarservicemen.bottomsheet

import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.adapter.car_screen.FiltrationBottomSheetAdapter
import com.example.coffeestarservicemen.adapter.car_screen.command.CommandAdapter
import com.example.coffeestarservicemen.databinding.BottomDialogCommandCarScreenBinding
import com.example.coffeestarservicemen.decoration.CustomItemDecorationFiltrationBottomSheet
import com.example.coffeestarservicemen.model.ItemCommand
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class FiltrationBottomSheetFragment: BottomSheetDialogFragment(R.layout.bottom_dialog_command_car_screen) {
    private val binding by viewBinding(BottomDialogCommandCarScreenBinding::bind)
    private var COLLAPSED_HEIGHT = 200
    private val list = mutableListOf<String>("All","Cleaning","Cup&Lid","Products","Door","Sell","Ice","Other")
    private val listCommand = mutableListOf<ItemCommand>(
        ItemCommand(
            title = "Cup&Lid",
            listCommand = listOf(
                "Drop cups","Drop lids","Home","Progress","Drop cup release","Empty cup move forward","Remote drop cup","Gland test"
            )
        ),
        ItemCommand(
            title = "Cleaning&Tuning",
            listCommand = listOf(
                "Clean","Clean mixer","Clean brewer","Clean syrup pump","Pipe emptying","Syrop pipe exhaust","Syrup clean"
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
            title = "Sale",
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
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val listNew = mutableListOf<String>()

        for (item in listCommand){
            listNew.addAll(item.listCommand)
        }

        with(binding){

            search.etSearch.hint = "Команда машине"

            rvFiltration.apply {
                layoutManager = FlexboxLayoutManager(requireContext()).apply {
                    flexWrap = FlexWrap.WRAP
                    flexDirection = FlexDirection.ROW
                    justifyContent = JustifyContent.FLEX_START
                }
                adapter = FiltrationBottomSheetAdapter(items = list){
                    behavior.state = BottomSheetBehavior.STATE_EXPANDED
                }
                addItemDecoration(
                    CustomItemDecorationFiltrationBottomSheet(
                        spaceTop = resources.getDimensionPixelSize(R.dimen.marginTop_recyclerView_Filtration_BottomSheet),
                        spaceRight = resources.getDimensionPixelSize(R.dimen.marginEnd_recyclerView_Filtration_BottomSheet)
                    )
                )
            }

            val bottomSheetGeneral = ActionCommandGeneralBottomSheetFragment(
                requireContext(),layoutInflater,generalCommandInterface
            )

            rvCommand.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = CommandAdapter(items = listCommand){
                    this@FiltrationBottomSheetFragment.binding.root.visibility = View.GONE
                    bottomSheetGeneral.show(it)
                }
            }

            rvFiltration.viewTreeObserver.addOnGlobalLayoutListener(observer)
        }

    }

    private val observer = ViewTreeObserver.OnGlobalLayoutListener { countingStartingHeightDialog() }

    private var isExpanded = false
    private lateinit var behavior:BottomSheetBehavior<FrameLayout>

    private fun countingStartingHeightDialog(){
        COLLAPSED_HEIGHT = 32 + 10
        val density = requireContext().resources.displayMetrics.density

        dialog?.let {
            val bottomSheet = it.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
            behavior = BottomSheetBehavior.from(bottomSheet)
            behavior.peekHeight = ((COLLAPSED_HEIGHT * density)+ binding.search.etSearch.height + binding.rvFiltration.height).toInt()
            behavior.state = BottomSheetBehavior.STATE_COLLAPSED

            /*behavior.addBottomSheetCallback(object : BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    if (BottomSheetBehavior.STATE_COLLAPSED == newState && isExpanded) {
                        isExpanded = false
                        binding.rvFiltration.apply {
                            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT).apply {
                                setMargins((16 * density).toInt(), (4 * density).toInt(), (16 * density).toInt(),0)
                            }
                            layoutManager = FlexboxLayoutManager(requireContext()).apply {
                                flexWrap = FlexWrap.WRAP
                                flexDirection = FlexDirection.ROW
                                justifyContent = JustifyContent.FLEX_START
                            }
                        }
                        behavior.state = BottomSheetBehavior.STATE_COLLAPSED
                    } else if (BottomSheetBehavior.	STATE_EXPANDED == newState && !isExpanded) {
                        isExpanded = true
                        binding.rvFiltration.apply {
                            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT).apply {
                                setMargins(0, 0, 0,0)
                            }
                            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
                        }
                        behavior.state = BottomSheetBehavior.STATE_EXPANDED
                    }
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {}
            })*/
        }
    }


    private val generalCommandInterface = object :GeneralCommandInterface{
        override fun click() {
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
            this@FiltrationBottomSheetFragment.binding.root.visibility = View.VISIBLE
        }
    }

}