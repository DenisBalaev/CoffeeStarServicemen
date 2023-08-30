package com.example.coffeestarservicemen.fragment.car_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.BottomNavInterface
import com.example.coffeestarservicemen.MyFragment
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.adapter.card_car.TabPageAdapter
import com.example.coffeestarservicemen.databinding.FragmentCarScreenBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_car_screen_statuses.*


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

            viewPage.adapter = adapter

            TabLayoutMediator(tabLayout,viewPage){tab,position->
                tab.text = adapter.titleList[position]
            }.attach()

            repeat(adapter.titleList.count()){
                val textView = LayoutInflater.from(requireContext()).inflate(R.layout.item_title_tab_layout,null) as TextView
                tabLayout.getTabAt(it)!!.customView = textView
            }
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