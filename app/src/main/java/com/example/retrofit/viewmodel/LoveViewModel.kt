package com.example.retrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit.remote.LoveModel
import com.example.retrofit.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository): ViewModel()  {

    fun getLiveLoveModel(firstName: String, secondName: String): LiveData<LoveModel>{
        return repository.getLiveLove(firstName, secondName)
    }
}