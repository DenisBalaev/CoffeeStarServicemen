package com.example.coffeestarservicemen

import android.view.View

object MyFragment {
    fun bottomNavVisible(activity:BottomNavInterface,idLayout:Int){
        if (idLayout == R.layout.fragment_car_screen) {
            activity.bottomNavVisibility(View.GONE)
        }else{
            activity.bottomNavVisibility(View.VISIBLE)
        }
    }
}