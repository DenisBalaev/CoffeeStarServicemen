package com.example.coffeestarservicemen.fragment.car_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.adapter.FragmentStateAdapter
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.BottomNavInterface
import com.example.coffeestarservicemen.MyFragment
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.adapter.card_car.TabPageAdapter
import com.example.coffeestarservicemen.databinding.FragmentCarScreenBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class CarScreenFragment : Fragment(R.layout.fragment_car_screen) {
    private val binding by viewBinding(FragmentCarScreenBinding::bind)
    private val args: CarScreenFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter = activity?.let {
            TabPageAdapter(it).apply {
                repeat(6) {
                    addFragment(CarScreenStatusFragment(), "Статус $it")
                }
            }
        }

        with(binding){
            ivArrowBack.setOnClickListener {
                findNavController().popBackStack()
            }

            viewPage.adapter = adapter
            val tabLayoutMediator = TabLayoutMediator(tabLayout, viewPage) { tab, position ->
                tab.text = "Страница " + (position + 1)
            }
            tabLayoutMediator.attach()
        }
    }

    override fun onStart() {
        super.onStart()
        MyFragment.bottomNavVisible(
            activity = (activity as BottomNavInterface),
            idLayout = R.layout.fragment_car_screen
        )
    }


}