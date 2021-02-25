package com.project.loginmvpkotlin.View.Login.Presenter

import com.project.loginmvpkotlin.Network.ConfigNetwork
import com.project.loginmvpkotlin.View.Login.LoginView
import com.project.loginmvpkotlin.View.Login.Model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter (val loginView: LoginView) {

    fun login(email : String, password : String){

        if(email.isNotEmpty() && password.isNotEmpty()){
            ConfigNetwork.getNetwork().login(email, password)
                .enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        if (response.isSuccessful) {
                            val status = response.body()?.isSuccess
                            val message = response.body()?.message

                            if (status == true) {
                                response.body()?.data?.let {
                                    if (message != null) {
                                        loginView.loginSuccess(message, it)
                                    }
                                }
                            } else {
                                loginView.errorLogin(message ?: "")
                            }
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        loginView.errorLogin(t.localizedMessage)
                    }

                })
        }else{
            loginView.errorLogin("tidak boleh ada yang kosong")
        }
    }
}