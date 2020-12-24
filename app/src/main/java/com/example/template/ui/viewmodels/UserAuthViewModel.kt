package com.example.template.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.template.repository.Firebase.FirebaseRepository
import com.example.template.Utils.Event
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.lang.Exception

/**
 * Created by Mehul Bisht on 20-12-2020
 */

class UserAuthViewModel : ViewModel(){

    private val _didSignUpSucceed = MutableLiveData<Event<String>>()
    val didSignUpSucceed : LiveData<Event<String>>
        get() = _didSignUpSucceed

    private val _didSignInSucceed = MutableLiveData<Event<String>>()
    val didSignInSucceed : LiveData<Event<String>>
        get() = _didSignInSucceed

    fun signUp(email: String,password: String){
        viewModelScope.launch {
            try {
                _didSignUpSucceed.value = Event("Loading")
                FirebaseRepository().getAuth().createUserWithEmailAndPassword(email,password).await()
                _didSignUpSucceed.value = Event("Success")
            } catch (e: Exception){
                _didSignUpSucceed.value = Event("Failure")
                Log.d("error ", "${e.message}")
            }
        }
    }

    fun signIn(email: String, password: String) {

        viewModelScope.launch {
            try{
                FirebaseRepository().getAuth().signInWithEmailAndPassword(email,password).await()
                _didSignInSucceed.value = Event("Success")
            } catch (e: Exception){
                _didSignInSucceed.value = Event("Failure")
                Log.d("error ", "${e.message}")
            }
        }
    }

}
