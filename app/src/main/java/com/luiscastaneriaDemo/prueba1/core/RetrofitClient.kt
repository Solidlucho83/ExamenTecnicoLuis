package com.luiscastaneriaDemo.prueba1.core

import com.google.gson.GsonBuilder
import com.luiscastaneriaDemo.prueba1.data.WebService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    var okHttpClient = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .build()

    val webService: WebService by lazy {
        Retrofit.Builder()
            .baseUrl("https://61967289af46280017e7e0c0.mockapi.io/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
     fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://61967289af46280017e7e0c0.mockapi.io/devices/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}