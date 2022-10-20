package com.solanacode.makeupapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.solanacode.makeupapi.api.RestfulApi
import com.solanacode.makeupapi.model.MakeUp
import com.solanacode.makeupapi.model.MakeUpItem
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MakeUpViewModel @Inject constructor(var api : RestfulApi) : ViewModel() {

    lateinit var liveDataMakeUp : MutableLiveData<List<MakeUpItem>>

    init {
        liveDataMakeUp = MutableLiveData()
    }

    fun getLiveDataProduct() : MutableLiveData<List<MakeUpItem>> {
        return liveDataMakeUp
    }

    fun callApiMakeUp(){
        api.getAllProduct()
            .enqueue(object : Callback<List<MakeUpItem>> {
                override fun onResponse(
                    call: Call<List<MakeUpItem>>,
                    response: Response<List<MakeUpItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataMakeUp.postValue(response.body())
                    } else{
                        liveDataMakeUp.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<MakeUpItem>>, t: Throwable) {
                    liveDataMakeUp.postValue(null)
                }

            })
    }
}