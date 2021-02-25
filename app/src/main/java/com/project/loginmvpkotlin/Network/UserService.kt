package com.project.loginmvpkotlin.Network

import com.project.loginmvpkotlin.View.Login.Model.LoginResponse
import com.project.loginmvpkotlin.View.Register.Model.RegisterResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserService {

    @FormUrlEncoded
    @POST("Register.php")
    fun register(
        @Field("nama") nama : String,
        @Field("nohp") noHp : String,
        @Field("email") email : String,
        @Field("password") password : String
    ): Single<RegisterResponse>

    @FormUrlEncoded
    @POST("Login.php")
    fun login(
            @Field("email") email : String,
            @Field("password") password : String
    ): Call<LoginResponse>
}