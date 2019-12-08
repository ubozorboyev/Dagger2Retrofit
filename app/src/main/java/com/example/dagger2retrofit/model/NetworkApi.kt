package com.example.dagger2retrofit.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NetworkApi @Inject constructor(){
private val api=NetWorkModel.getApiRetrofit()


    fun loadAllItems():LiveData<List<Data>> {
        Log.d("TTT","loadAllItems")
        val data=MutableLiveData<List<Data>>()
        api.getAllItems().enqueue(object :Callback<ModelData>{
            override fun onFailure(call: Call<ModelData>, t: Throwable) {
                t.printStackTrace()
                Log.d("TTT","Throwable $t")
            }

            override fun onResponse(
                call: Call<ModelData>,
                response: Response<ModelData>
            ) {
                Log.d("TTT","response ${response.body()}")
              if (response.isSuccessful){
                  data.value=response.body()?.data
              }
            }

        })
        return data
    }



}