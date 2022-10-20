package com.solanacode.makeupapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.solanacode.makeupapi.R
import com.solanacode.makeupapi.adapter.MakeUpAdapter
import com.solanacode.makeupapi.databinding.ActivityMainBinding
import com.solanacode.makeupapi.viewmodel.MakeUpViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var makeUpAdapter: MakeUpAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getlistMakeup()
    }

    fun getlistMakeup(){
        val viewmodel = ViewModelProvider(this).get(MakeUpViewModel::class.java)

        viewmodel.getLiveDataProduct().observe(this, Observer {
            makeUpAdapter = MakeUpAdapter(it)
            if (it != null){
                binding.rvMain.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
                binding.rvMain.adapter = MakeUpAdapter(it)
            }
        })
        viewmodel.callApiMakeUp()
    }
}