package com.example.template.repository.API

import com.example.template.Utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Mehul Bisht on 22-12-2020
 */
class RetrofitInstance {

    companion object {

        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api by lazy {
            retrofit.create(API_Interface::class.java)
        }

    }

}