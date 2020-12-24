package com.example.template.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.template.repository.API.API_Repository
import com.example.template.repository.API.BrawlerModel

/**
 * Created by Mehul Bisht on 20-12-2020
 */

class HomeViewModel : ViewModel() {

    private var _brawlerData = MutableLiveData<ArrayList<BrawlerModel>>()
    val brawlerData: LiveData<ArrayList<BrawlerModel>> get() = _brawlerData

    fun getData() : LiveData<ArrayList<BrawlerModel>> {
        return API_Repository().getApiData()
    }

}