package com.example.retrofit.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class OnBoardViewModel @Inject constructor(private val pref: SharedPreferences): ViewModel() {


    fun onBoardShow(): Boolean{
       return pref.getBoolean(BOARD_SHOW, false)
    }

    fun saveShowBoard(isShow: Boolean){
        pref.edit().putBoolean(BOARD_SHOW, isShow).apply()
    }
    companion object{
        private const val BOARD_SHOW = "onboarding.show"
    }
}