package com.example.template.repository.Firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

/**
 * Created by Mehul Bisht on 20-12-2020
 */

class FirebaseRepository {

    private val firebaseAuth : FirebaseAuth = FirebaseAuth.getInstance()
    private val firebaseFirestore : FirebaseFirestore = FirebaseFirestore.getInstance()

    fun getUser() : FirebaseUser?{
        return firebaseAuth.currentUser
    }

    fun getAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    suspend fun saveNote(note: Note){

        val noteToBeSaved = hashMapOf(
            "text" to note.text,
            "title" to note.title,
            "topic" to note.topic,
            "timeStamp" to note.timeStamp,
            "createdBy" to note.createdBy
        )

        firebaseFirestore.collection("notes").document(note.title)
            .set(noteToBeSaved)
            .await()
    }

}