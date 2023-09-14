package com.example.coffeestarservicemen

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(R.layout.activity_main),BottomNavInterface {

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navController = findNavController(R.id.nav_host_fragment)
        binding.bottomNavigationView.setupWithNavController(navController)
    }

    override fun bottomNavVisibility(visibility: Int) {
        binding.bottomNavigationView.visibility = visibility
    }

}