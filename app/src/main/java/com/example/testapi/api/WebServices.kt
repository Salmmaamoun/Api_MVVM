package com.example.testapi.api

import com.example.testapi.model.Response
import com.example.testapi.model.Surah
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {
@GET("262")
    fun getAya():Call<Response>


}