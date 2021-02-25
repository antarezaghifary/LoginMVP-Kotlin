package com.project.loginmvpkotlin.View.Login

import com.project.loginmvpkotlin.View.Login.Model.DataItem

interface LoginView {
    fun loginSuccess(mgs : String, user : List<DataItem?>)
    fun errorLogin(msg : String)
}