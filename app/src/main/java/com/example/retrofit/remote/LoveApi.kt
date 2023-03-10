package com.example.retrofit.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET ("getPercentage")
    fun getResultLove(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com")
        : Call<LoveModel>
}