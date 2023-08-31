package com.example.coffeestarservicemen.fragment.car_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
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
import kotlinx.android.synthetic.main.fragment_new_note.*

class CarScreenFragment : Fragment(R.layout.fragment_car_screen) {
    private val binding by viewBinding(FragmentCarScreenBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter = TabPageAdapter(fragmentManager = childFragmentManager, lifecycle = lifecycle).apply {
            addFragment(CarScreenStatusesFragment(), "Статусы")
            addFragment(CarScreenNotesFragment(), "Заметки")
            addFragment(CarScreenHistoryFragment(), "История")
        }

        with(binding){
            viewPage.adapter = adapter
            TabLayoutMediator(tabLayout,viewPage){tab,position->
                tab.text = adapter.titleList[position]
            }.attach()

            repeat(adapter.titleList.size){
                val textView = LayoutInflater.from(requireContext()).inflate(R.layout.item_title_tab_layout,null) as TextView
                tabLayout.getTabAt(it)!!.customView = textView
            }
            viewPage.setCurrentItem(requireArguments().getInt("SelectorPage"), false)

            ivArrowBack.setOnClickListener {
                findNavController().navigate(R.id.carsFragment)
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