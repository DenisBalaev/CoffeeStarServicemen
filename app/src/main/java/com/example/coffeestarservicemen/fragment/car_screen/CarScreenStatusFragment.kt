package com.example.coffeestarservicemen.fragment.car_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.MainActivity
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.databinding.FragmentCarScreenStatusBinding

class CarScreenStatusFragment : Fragment(R.layout.fragment_car_screen_status) {
    private val binding by viewBinding(FragmentCarScreenStatusBinding::bind)

    private val args: CarScreenStatusFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tv.text = args.itemCarModel.toString()
    }

}