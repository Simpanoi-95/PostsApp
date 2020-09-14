package com.example.postsapp.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Url

object ApiClient {
    var client=OkHttpClient.Builder().build()
    var retrofit= Retrofit.Builder()
        .baseUrl("http://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    fun <T> buildServices(service:Class<T>):T{
        return retrofit.create(service)
    }

}