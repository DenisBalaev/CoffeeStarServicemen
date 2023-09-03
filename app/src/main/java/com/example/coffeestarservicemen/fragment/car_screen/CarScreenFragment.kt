package com.example.coffeestarservicemen.fragment.car_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.BottomNavInterface
import com.example.coffeestarservicemen.MyFragment
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.adapter.car_screen.TabPageAdapter
import com.example.coffeestarservicemen.bottomsheet.FiltrationBottomSheetFragment
import com.example.coffeestarservicemen.databinding.FragmentCarScreenBinding
import com.example.coffeestarservicemen.databinding.ItemTitleTabLayoutBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_car_screen.*

class CarScreenFragment : Fragment(R.layout.fragment_car_screen) {
    private val binding by viewBinding(FragmentCarScreenBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter = TabPageAdapter(fragmentManager = childFragmentManager, lifecycle = lifecycle).apply {
            addFragment(CarScreenStatusesFragment(), "Статусы")
            addFragment(CarScreenNotesFragment(), "Заметки")
            addFragment(CarScreenHistoryFragment(), "История")
        }

        val bottomSheetDialog = FiltrationBottomSheetFragment()

        with(binding){
            viewPage.adapter = adapter
            TabLayoutMediator(tabLayout,viewPage){tab,position->
                tab.text = adapter.titleList[position]
            }.attach()

            repeat(adapter.titleList.size){
                tabLayout.getTabAt(it)!!.customView = ItemTitleTabLayoutBinding.inflate(layoutInflater).text1
            }
            viewPage.setCurrentItem(requireArguments().getInt("SelectorPage"), false)

            ivArrowBack.setOnClickListener {
                findNavController().navigate(R.id.carsFragment)
            }

            ivSend.setOnClickListener {
                bottomSheetDialog.show(childFragmentManager,bottomSheetDialog.tag)
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