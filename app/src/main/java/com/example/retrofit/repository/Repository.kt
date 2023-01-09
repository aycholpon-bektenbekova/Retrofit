package com.example.retrofit.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.retrofit.remote.LoveApi
import com.example.retrofit.remote.LoveModel
import com.example.retrofit.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi){
    fun getLiveLove(firstName:String, secondName:String) : MutableLiveData<LoveModel>{
        val liveData = MutableLiveData<LoveModel>()
        api.getResultLove(firstName, secondName).enqueue(object : Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    liveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("aic", "onFailure: ${t.message}")
            }
        })

        return liveData
    }
}