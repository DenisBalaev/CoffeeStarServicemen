package com.example.coffeestarservicemen.bottomsheet

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.databinding.BottomDialogCarScreenBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FiltrationBottomSheetFragment: BottomSheetDialogFragment(R.layout.bottom_dialog_car_screen) {
    private val binding by viewBinding(BottomDialogCarScreenBinding::bind)

}