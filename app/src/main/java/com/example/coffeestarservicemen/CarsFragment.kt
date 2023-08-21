package com.example.coffeestarservicemen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coffeestarservicemen.databinding.FragmentCarsBinding


class CarsFragment : Fragment() {

    private lateinit var binding:FragmentCarsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCarsBinding.inflate(inflater, container, false)
        return binding.root
    }

}