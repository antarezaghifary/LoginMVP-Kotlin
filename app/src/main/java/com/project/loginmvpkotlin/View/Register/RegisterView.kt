package com.project.loginmvpkotlin.View.Register

import com.project.loginmvpkotlin.View.Register.Model.RegisterResponse

interface RegisterView {
    fun successRegister(response: RegisterResponse)
    fun errorRegister(msg : String)
    fun empty()
    fun noMatch()
    fun startProgressBar()
    fun hideProgressBar()
}