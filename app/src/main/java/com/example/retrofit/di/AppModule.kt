package com.example.retrofit.di

import android.content.Context
import android.content.SharedPreferences
import com.example.retrofit.remote.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
class AppModule {

    @Provides
    fun provideApi(): LoveApi{
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/").
                addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun onBoard(context: Context) : SharedPreferences{
        return context.getSharedPreferences("pref_name", Context.MODE_PRIVATE)
    }
}