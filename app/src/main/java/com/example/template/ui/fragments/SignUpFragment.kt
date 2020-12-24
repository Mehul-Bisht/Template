package com.example.template.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.template.databinding.FragmentSignupBinding
import com.example.template.ui.viewmodels.UserAuthViewModel

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!

    val userAuthViewModel: UserAuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signup.setOnClickListener {

            val email = binding.email.editText?.text.toString()
            val pass = binding.pass.editText?.text.toString()
            userAuthViewModel.signUp(email,pass)

            userAuthViewModel.didSignUpSucceed.observe(viewLifecycleOwner,{ signUpStatus ->
                signUpStatus.getContentIfNotHandled()?.let {
                    if(it == "Success"){
                        val navController = findNavController()
                        navController.navigate(SignUpFragmentDirections.actionSignUpFragment2ToEntranceFragment())
                    }
                }
            })

        }

        binding.signInButton.setOnClickListener {
            val navController = findNavController()
            navController.navigate(SignUpFragmentDirections.actionSignUpFragment2ToSignInFragment2())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}