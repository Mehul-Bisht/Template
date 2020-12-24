package com.example.template.repository.API

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Mehul Bisht on 22-12-2020
 */

interface API_Interface {

    @GET("chromatic")
    fun getBrawlers() : Call<ArrayList<BrawlerModel>>

    companion object{
        fun getApiResponse() : API_Interface {
            return RetrofitInstance.api
        }
    }
}