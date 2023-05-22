package com.example.testapi

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapi.api.ApiManger
import com.example.testapi.model.Response
import retrofit2.Call
import retrofit2.Callback

class MainViewModel:ViewModel() {
    var ayah=MutableLiveData<String>()
    fun getAyah(){
        ApiManger.getApi().getAya().enqueue(object : Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                ayah.value= response.body()?.data?.text.toString()
                Log.e("succes", response.body()?.data?.text.toString())

            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.e("fail", t.message.toString())
            }

        })
    }
}