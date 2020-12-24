package com.example.template.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.template.repository.Firebase.FirebaseRepository
import com.example.template.Utils.Event

/**
 * Created by Mehul Bisht on 24-12-2020
 */

class EntranceViewModel : ViewModel() {

    private var _isUserInitialised = MutableLiveData<Event<Boolean>>()
    val isUserInitialised: LiveData<Event<Boolean>> get() = _isUserInitialised

    fun checkUserAuth(){
        if(FirebaseRepository().getUser() == null){
            _isUserInitialised.value = Event(false)
        } else{
            _isUserInitialised.value = Event(true)
        }
    }

    fun signOut(){
        FirebaseRepository().getAuth().signOut()
    }

}