package com.example.coffeestarservicemen.adapter.car_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabPageAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragmentList:MutableList<Fragment> = ArrayList()
    val titleList:MutableList<String> = ArrayList()

    override fun getItemCount(): Int {
       return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return if (titleList[position] == "Заметки"){
            fragmentList[position].apply {
                arguments = Bundle().apply {
                    putInt(ARG_SELECT_TAB_PAGE, position)
                }
            }
        }else{
            fragmentList[position]
        }
    }

    fun addFragment(fragment: Fragment, title:String){
        fragmentList.add(fragment)
        titleList.add(title)
    }

    companion object {
        const val ARG_SELECT_TAB_PAGE = "object"
    }
}