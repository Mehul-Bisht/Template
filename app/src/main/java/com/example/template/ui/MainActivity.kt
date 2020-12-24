package com.example.template.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.template.R
import com.example.template.Utils.BottomNavViewExt.setupWithNavController
import com.example.template.databinding.ActivityMainBinding
import com.example.template.ui.viewmodels.EntranceViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.entranceFragment,
                R.id.homeFragment,
                R.id.firebaseFragment
            )
        )

        val navController = navHostFragment.navController
        val controller = findViewById<BottomNavigationView>(R.id.bottom_nav).setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->

            if(destination.id == R.id.signInFragment2 || destination.id == R.id.signUpFragment2){
                binding.bottomNav.visibility = View.GONE
            } else {
                binding.bottomNav.visibility = View.VISIBLE
            }

        }

    }

}