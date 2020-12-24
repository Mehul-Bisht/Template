package com.example.template.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.template.R
import com.example.template.Utils.BottomNavViewExt.setupWithNavController
import com.example.template.databinding.ActivityMainBinding
import com.example.template.ui.viewmodels.EntranceViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var entranceViewModel: EntranceViewModel
    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        entranceViewModel = ViewModelProvider(this).get(EntranceViewModel::class.java)

        entranceViewModel.isUserInitialised.observe(this) {
            it.getContentIfNotHandled()?.let { isUserLoggedIn ->
                if (isUserLoggedIn) {
                    setupBottomNavigationBar()
                }
            }
        }

        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }

        /*val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.entranceFragment,
                R.id.homeFragment,
                R.id.firebaseFragment
            )
        )

        //val navController = navHostFragment.navController
        val controller = findViewById<BottomNavigationView>(R.id.bottom_nav).setupWithNavController(
            listOf(R.navigation.nav_graph),
            //Hold on comparing code Ok
            supportFragmentManager,
            R.id.nav_host_fragment,
            intent
        )

//        navController.addOnDestinationChangedListener { _, destination, _ ->
//
//            if(destination.id == R.id.signInFragment2 || destination.id == R.id.signUpFragment2){
//                binding.bottomNav.visibility = View.GONE
//            } else {
//                binding.bottomNav.visibility = View.VISIBLE
//            }
//
//        }*/

    }

    private fun setupBottomNavigationBar()
    {
        val navGraphIds = listOf(
            R.navigation.home_graph,
            R.navigation.firebase_graph
        )

        val controller = binding.bottomNav.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_fragment,
            intent = intent
        )

        controller.observe(this) {
            setupActionBarWithNavController(it)
        }
        currentNavController = controller
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (entranceViewModel.isUserInitialised.value?.peekContent() == true) {
            setupBottomNavigationBar()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }
}