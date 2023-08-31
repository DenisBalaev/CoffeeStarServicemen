package com.example.coffeestarservicemen.fragment.car_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.databinding.FragmentNewNoteBinding
import com.example.coffeestarservicemen.fragment.CarsFragmentDirections

class NewNoteFragment : Fragment(R.layout.fragment_new_note) {
    private val binding by viewBinding(FragmentNewNoteBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding){
            ivArrowBack.setOnClickListener {
                findNavController().navigate(R.id.carScreenFragment, bundleOf("SelectorPage" to 1))
            }
        }
    }
}