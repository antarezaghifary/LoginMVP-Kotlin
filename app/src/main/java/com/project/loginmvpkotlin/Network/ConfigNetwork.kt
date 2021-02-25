package com.project.loginmvpkotlin.Network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {
    companion object
    {
        fun getNetwork() : UserService{
            val retrofit =  Retrofit.Builder()
                .baseUrl("http://192.168.0.111/mentoringkotlin/")
                .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()

            val service = retrofit.create(UserService::class.java)
            return service
        }
    }
}