package com.example.template.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.template.R
import com.example.template.databinding.FragmentSigninBinding
import com.example.template.ui.viewmodels.UserAuthViewModel
import com.google.android.material.snackbar.Snackbar

class SignInFragment : Fragment() {

    private var _binding: FragmentSigninBinding? = null
    private val binding get() = _binding!!

    val userAuthViewModel: UserAuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSigninBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signin.setOnClickListener {

            val email = binding.email.editText?.text.toString()
            val pass = binding.pass.editText?.text.toString()

           userAuthViewModel.signIn(email,pass)

           userAuthViewModel.didSignInSucceed.observe(viewLifecycleOwner,{ signInStatus ->
               signInStatus.getContentIfNotHandled()?.let {

                   when(it){
                       "Loading" -> {
                           binding.progressBar.visibility = View.VISIBLE
                           binding.signin.isEnabled = false
                       }
                       "Success" -> {
                           binding.progressBar.visibility = View.GONE
                           binding.signin.isEnabled = true
                           val navController = findNavController()
                           navController.navigate(SignInFragmentDirections.actionSignInFragment2ToEntranceFragment())
                       }
                       "Failure" -> {
                           binding.progressBar.visibility = View.GONE
                           binding.signin.isEnabled = true
                           Snackbar.make(binding.signin,"Sign in failed",Snackbar.LENGTH_SHORT)
                       }
                   }

               }
           })

        }

        binding.forgotPass.setOnClickListener {
            val navController = findNavController()
            navController.navigate(SignInFragmentDirections.actionSignInFragment2ToForgotPassFragment())
        }

        binding.signUpButton.setOnClickListener {
            val navController = findNavController()
            navController.navigate(SignInFragmentDirections.actionSignInFragment2ToSignUpFragment2())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}