package com.example.template.Utils

/**
 * Created by Mehul Bisht on 22-12-2020
 */

open class Event<out T> (private val content: T) {

    var hasBeenHandled = false
     private set

    fun getContentIfNotHandled() :T?{
        return if(hasBeenHandled){
            null
        } else{
            hasBeenHandled = true
            content
        }
    }

    fun peekContent() :T = content

}