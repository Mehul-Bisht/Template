package com.example.template.repository.API

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Mehul Bisht on 23-12-2020
 */
class API_Repository {

    private val _mutableLiveData : MutableLiveData<ArrayList<BrawlerModel>>? = MutableLiveData()

    fun getApiData() : LiveData<ArrayList<BrawlerModel>>{

        API_Interface.getApiResponse()
            .getBrawlers()
            .enqueue(object : Callback<ArrayList<BrawlerModel>>{
                override fun onResponse(
                    call: Call<ArrayList<BrawlerModel>>,
                    response: Response<ArrayList<BrawlerModel>>) {

                    if(response.code() == 200) {
                        val brawlers = response.body()
                        _mutableLiveData?.value = brawlers
                    }
                }

                override fun onFailure(call: Call<ArrayList<BrawlerModel>>, t: Throwable) {
                    Log.d("API error ","${t.message}")
                }
            })

        return _mutableLiveData!!

    }

}