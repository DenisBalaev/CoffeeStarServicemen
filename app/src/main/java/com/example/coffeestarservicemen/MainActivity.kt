package com.example.coffeestarservicemen


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(R.layout.activity_main),BottomNavInterface {

    val binding by viewBinding(ActivityMainBinding::bind)
    lateinit var softInputAssist:SoftInputAssist

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        softInputAssist = SoftInputAssist(this)
        val navController = findNavController(R.id.nav_host_fragment)
        binding.bottomNavigationView.setupWithNavController(navController)
    }

    override fun bottomNavVisibility(visibility: Int) {
        binding.bottomNavigationView.visibility = visibility
    }

    override fun onResume() {
        super.onResume()
        softInputAssist.onResume()
    }

    override fun onPause() {
        softInputAssist.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        softInputAssist.onDestroy()
        super.onDestroy()
    }
}