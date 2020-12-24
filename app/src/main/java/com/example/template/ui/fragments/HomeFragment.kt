package com.example.template.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.template.R
import com.example.template.databinding.FragmentHomeBinding
import com.example.template.adapters.rv_adapter
import com.example.template.ui.viewmodels.HomeViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(" onCreateView ","HomeFragment")
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(" onViewCreated ","HomeFragment")

        homeViewModel.getData().observe(viewLifecycleOwner, Observer {
            val rAdapter = rv_adapter(requireContext(),it)
            binding.rv.adapter = rAdapter
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}