package com.project.loginmvpkotlin.View.Register.Presenter

import com.project.loginmvpkotlin.Network.ConfigNetwork
import com.project.loginmvpkotlin.View.Register.Model.RegisterResponse
import com.project.loginmvpkotlin.View.Register.RegisterView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Response

class RegisterPresenter  (val registerView: RegisterView){

    fun register(nama : String, hp: String, email : String, password : String, passwordConfirm : String){

        registerView.startProgressBar()

        ConfigNetwork.getNetwork().register(nama,hp,email,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                        registerView.successRegister(it)
                        registerView.hideProgressBar()
                },{
                        registerView.errorRegister(it.localizedMessage)
                        registerView.hideProgressBar()
                })


        registerView.startProgressBar()

        if(nama.isNotEmpty() && hp.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
            registerView.hideProgressBar()
            if(password != passwordConfirm){
                registerView.noMatch()
                registerView.hideProgressBar()
            }
            else if(password.length < 6){
                registerView.errorRegister("password harus minimal 7")
                registerView.hideProgressBar()
            }
            else {
                registerView.hideProgressBar()

//                ConfigNetwork.getNetwork().register(nama, hp, email, password)
//                .enqueue(object : retrofit2.Callback<RegisterResponse> {
//                    override fun onResponse(
//                            call: Call<RegisterResponse>,
//                            response: Response<RegisterResponse>
//                    ) {
//                        if (response.isSuccessful) {
//                            val responseServer = response.body()
//                            val message = response.body()?.message
//                            val status = response.body()?.isSuccess
//                            if (status == true) {
//                                responseServer?.let { registerView.successRegister(it) }
//                                registerView.hideProgressBar()
//                            } else {
//                                message?.let { registerView.errorRegister(it) }
//                                registerView.hideProgressBar()
//                            }
//                        }
//                    }
//
//                    override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
//                        registerView.errorRegister(t.localizedMessage)
//                        registerView.hideProgressBar()
//                    }
//                })

            }
        }else{
            registerView.empty()
            registerView.hideProgressBar()
        }
    }
}