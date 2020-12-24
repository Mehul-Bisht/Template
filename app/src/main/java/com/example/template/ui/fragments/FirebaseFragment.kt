package com.example.template.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.template.R
import com.example.template.databinding.FragmentFirebaseBinding
import com.example.template.ui.viewmodels.FirebaseViewModel

class FirebaseFragment : Fragment() {

    private var _binding: FragmentFirebaseBinding? = null
    private val binding get() = _binding!!

    private val firebaseViewModel: FirebaseViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(" onCreateView ","FirebaseFragment")
        _binding = FragmentFirebaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(" onViewCreated ","FirebaseFragment")

        binding.apply {

            save.setOnClickListener {

                val title = titleLayout.editText?.text.toString()
                val topic = topicLayout.editText?.text.toString()
                val text = textLayout.editText?.text.toString()

                firebaseViewModel.setData(title, topic, text)

            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}