package com.example.testapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testapi.api.ApiManger
import com.example.testapi.databinding.ActivityMainBinding
import com.example.testapi.model.Response
import com.example.testapi.model.Surah
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getAyah()
        observeViewModel()

    }

    fun observeViewModel(){
        viewModel.ayah.observe(this,object:Observer<String>{
            override fun onChanged(t: String?) {
                viewBinding.ayahTv.text=t!!
            }

        })
    }
}

