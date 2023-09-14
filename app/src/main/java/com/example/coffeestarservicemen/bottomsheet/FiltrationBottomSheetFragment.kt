package com.example.coffeestarservicemen.bottomsheet

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.SoftInputAssistFragment
import com.example.coffeestarservicemen.adapter.car_screen.FiltrationBottomSheetAdapter
import com.example.coffeestarservicemen.adapter.car_screen.command.CommandAdapter
import com.example.coffeestarservicemen.databinding.BottomDialogCommandCarScreenBinding
import com.example.coffeestarservicemen.decoration.CustomItemDecorationFiltrationBottomSheet
import com.example.coffeestarservicemen.model.ItemCommand
import com.example.coffeestarservicemen.model.ItemFilter
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class FiltrationBottomSheetFragment: BottomSheetDialogFragment(R.layout.bottom_dialog_command_car_screen) {
    private val binding by viewBinding(BottomDialogCommandCarScreenBinding::bind)
    private var COLLAPSED_HEIGHT = 200
    private val list = mutableListOf<ItemFilter.ItemText>(
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL,R.style.DialogStyle)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val linearLayoutManagerCommand = LinearLayoutManager(requireContext())

        with(binding){
            search.etSearch.apply {
                hint = "Команда машине"
                setOnFocusChangeListener { _, _ ->
                    behavior.state = BottomSheetBehavior.STATE_EXPANDED
                }
                setOnClickListener {
                    behavior.state = BottomSheetBehavior.STATE_EXPANDED
                }
            }

            rvFiltration.apply {
                layoutManager = FlexboxLayoutManager(requireContext()).apply {
                    flexWrap = FlexWrap.WRAP
                    flexDirection = FlexDirection.ROW
                    justifyContent = JustifyContent.FLEX_START
                }
                adapter = FiltrationBottomSheetAdapter(items = list){itemFilter->
                    behavior.state = BottomSheetBehavior.STATE_EXPANDED
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

            rvFiltration.viewTreeObserver.addOnGlobalLayoutListener(observer)
        }
    }

    private val observer = ViewTreeObserver.OnGlobalLayoutListener { countingStartingHeightDialog() }
    private lateinit var behavior:BottomSheetBehavior<FrameLayout>

    private fun countingStartingHeightDialog(){
        COLLAPSED_HEIGHT = 32 + 10
        val density = requireContext().resources.displayMetrics.density

        dialog?.let {
            val bottomSheet = it.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
            behavior = BottomSheetBehavior.from(bottomSheet)
            behavior.peekHeight = ((COLLAPSED_HEIGHT * density)+ binding.search.etSearch.height + binding.rvFiltration.height).toInt()
        }

        //dialog?.window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    private val softInputAssist by lazy {
        SoftInputAssistFragment(this)
    }

    override fun onResume() {
        super.onResume()
        softInputAssist.onResume()
    }

    override fun onPause() {
        softInputAssist.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        softInputAssist.onDestroy()
        super.onDestroy()
    }
}