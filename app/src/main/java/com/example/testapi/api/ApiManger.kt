package com.example.testapi.api

import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManger {

    companion object {
        private var retrofit: Retrofit? = null
    fun getInstance(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("https://api.alquran.cloud/v1/ayah/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
        fun getApi(): WebServices {
            return getInstance().create(WebServices::class.java)
        }

    }


}