package com.example.template.repository.Firebase

/**
 * Created by Mehul Bisht on 24-12-2020
 */

data class Note (
    val text: String,
    val title: String,
    val topic: String,
    val timeStamp: Long,
    val createdBy: String
)