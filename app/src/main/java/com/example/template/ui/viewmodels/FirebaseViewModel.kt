package com.example.template.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.template.repository.Firebase.FirebaseRepository
import com.example.template.repository.Firebase.Note
import kotlinx.coroutines.launch

/**
 * Created by Mehul Bisht on 24-12-2020
 */

class FirebaseViewModel : ViewModel() {

    fun setData(title: String, topic: String, text: String){
        viewModelScope.launch {
            val currentTimeStamp = System.currentTimeMillis()
            FirebaseRepository().getUser()?.let {
                val email = it.email
                val note = Note(text,title,topic,currentTimeStamp,email!!)
                FirebaseRepository().saveNote(note)
            }
        }
    }

}