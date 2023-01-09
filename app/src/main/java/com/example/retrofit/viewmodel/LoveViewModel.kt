package com.example.retrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit.remote.LoveModel
import com.example.retrofit.repository.Repository

class LoveViewModel : ViewModel()  {

    private val repository = Repository()

    fun getLiveLoveModel(firstName: String, secondName: String): LiveData<LoveModel>{
        return repository.getLiveLove(firstName, secondName)
    }
}