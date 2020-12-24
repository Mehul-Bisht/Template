package com.example.template.Utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Mehul Bisht on 24-12-2020
 */

class DateTimeFormatter {

    companion object{

        private const val SECOND_MILLIS = 1000
        private const val MINUTE_MILLIS = 60 * SECOND_MILLIS
        private const val HOUR_MILLIS = 60 * MINUTE_MILLIS
        private const val DAY_MILLIS = 24 * HOUR_MILLIS

        fun getTimeAgo(time: Long) : String?{

            val now: Long = System.currentTimeMillis()
            if(time > now || time < 0){
                return null
            }

            val diff = now - time

            return if(diff < MINUTE_MILLIS){
                "just now"
            } else if(diff < 2 * MINUTE_MILLIS){
                "a minute ago"
            } else if(diff < 50 * MINUTE_MILLIS){
                "${(diff / MINUTE_MILLIS)} minutes ago"
            } else if(diff < 90 * MINUTE_MILLIS){
                "an hour ago"
            } else if(diff < 24 * HOUR_MILLIS){
                "${(diff / HOUR_MILLIS)} hours ago"
            } else if(diff < 48 * HOUR_MILLIS){
                "yesterday"
            } else {
                "${(diff / DAY_MILLIS)} days ago"
            }
        }

        fun getDate(time: Long) : String{

            val sdfDate = SimpleDateFormat("dd-MM-YYYY")
            val date = Date(time)
            val displayDate = sdfDate.format(date)

            return displayDate
        }

        fun getTime(time: Long) : String{

            val sdfTime = SimpleDateFormat("hh:mm:ss")
            val Time = Date(time)
            val displayTime = sdfTime.format(Time)

            return displayTime
        }

    }

}