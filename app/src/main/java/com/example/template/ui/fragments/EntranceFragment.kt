package com.example.template.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.template.R
import com.example.template.databinding.FragmentEntranceBinding
import com.example.template.ui.viewmodels.EntranceViewModel

class EntranceFragment : Fragment() {

    private var _binding: FragmentEntranceBinding? = null
    private val binding get() = _binding!!

    private lateinit var entranceViewModel: EntranceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(" onCreateView ","EntranceFragment")
        _binding = FragmentEntranceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(" onViewCreated ","EntranceFragment")

        activity?.let {
            // We must have to use activity context to share common VM between this frag and activity
            entranceViewModel = ViewModelProvider(it).get(EntranceViewModel::class.java)
        }

        entranceViewModel.checkUserAuth()

        entranceViewModel.isUserInitialised.observe(viewLifecycleOwner, { isUserInitialised ->

            isUserInitialised.getContentIfNotHandled()?.let {
                if(!it){
                    val navController = findNavController()
                    navController.navigate(R.id.signUpFragment2)
                }
            }

        })

        binding.signOut.setOnClickListener {
            entranceViewModel.signOut()
            val navController = findNavController()
            navController.navigate(R.id.signUpFragment2)
        }

    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }

}