package com.example.dagger2retrofit.model

import dagger.Module
import dagger.Provides
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const  val BASE_URL="https://demonuts.com/Demonuts/JsonTest/Tennis/"

@Module
object NetWorkModel {
    @JvmStatic
    @Provides
    fun getApiRetrofit():ApiRetrofit{
       return Retrofit.Builder()
              .baseUrl(BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
               .build().create(ApiRetrofit::class.java)
    }
}

interface ApiRetrofit{
    @GET("json_parsing.php/")
    fun getAllItems():Call<ModelData>

}

data class ModelData(
    val `data`: List<Data>,
    val message: String,
    val status: String
)

data class Data(
    val city: String,
    val country: String,
    val id: String,
    val imgURL: String,
    val name: String
)