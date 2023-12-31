package com.example.coffeestarservicemen.fragment.car_screen

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.MainActivity
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.SoftInputAssist
import com.example.coffeestarservicemen.databinding.FragmentNewNoteBinding
import com.example.coffeestarservicemen.fragment.CarsFragmentDirections
import com.example.coffeestarservicemen.fragment.car_screen.CarScreenNotesFragment.Companion.ARG_SELECT_PAGE


class NewNoteFragment : Fragment(R.layout.fragment_new_note) {
    private val binding by viewBinding(FragmentNewNoteBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        @Suppress("DEPRECATION")
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        val pageNote = requireArguments().getInt(ARG_SELECT_PAGE)

        with(binding){
            etNote.requestFocus()
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(etNote, InputMethodManager.SHOW_IMPLICIT)

            ivArrowBack.setOnClickListener {
                findNavController().navigate(R.id.carScreenFragment, bundleOf(ARG_SELECT_PAGE to pageNote))
            }

            btnSave.setOnClickListener {
                Toast.makeText(requireContext(),"Сохранение",Toast.LENGTH_SHORT).show()
            }
        }
    }
}