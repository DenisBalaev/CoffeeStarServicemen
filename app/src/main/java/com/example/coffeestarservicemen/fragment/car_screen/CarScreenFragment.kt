package com.example.coffeestarservicemen.fragment.car_screen

import androidx.viewpager2.widget.ViewPager2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.BottomNavInterface
import com.example.coffeestarservicemen.MyFragment
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.adapter.card_car.TabPageAdapter
import com.example.coffeestarservicemen.databinding.FragmentCarScreenBinding
import com.google.android.material.tabs.TabLayout


class CarScreenFragment : Fragment(R.layout.fragment_car_screen) {
    private val binding by viewBinding(FragmentCarScreenBinding::bind)
    private val args: CarScreenFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter = TabPageAdapter(activity).apply {
            addFragment(CarScreenStatusesFragment(), "Статусы")
            addFragment(CarScreenNotesFragment(), "Заметки")
            addFragment(CarScreenHistoryFragment(), "История")
        }

        with(binding){
            ivArrowBack.setOnClickListener {
                findNavController().popBackStack()
            }

            adapter.titleList.forEach {
                tabLayout.addTab(tabLayout.newTab().setText(it))
            }

            viewPage.adapter = adapter
            tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    viewPage.currentItem = tab!!.position
                }
                override fun onTabUnselected(tab: TabLayout.Tab?) {}
                override fun onTabReselected(tab: TabLayout.Tab?) {}
            })

            viewPage.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    tabLayout.selectTab(tabLayout.getTabAt(position))
                }
            })
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