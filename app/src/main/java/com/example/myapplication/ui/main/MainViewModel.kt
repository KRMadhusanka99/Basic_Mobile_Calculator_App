package com.example.myapplication.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var result = MutableLiveData<Double>(1.0)

    fun add(number1:Double,number2:Double){
        result.value=number1.plus(number2)
        //println(result.value)
        Log.d("Add Result",result.value.toString())
    }
}