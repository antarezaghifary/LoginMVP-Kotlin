package com.project.loginmvpkotlin.Helper

import android.content.Context
import android.content.SharedPreferences

class SessionManager (var con : Context) {

    var pref : SharedPreferences? = null
    var edt : SharedPreferences.Editor? = null
    var PREF_NAME = "LOGINREGISTER"

    var ISLOGIN = "isLogin"
    var NAMA = "nama"
    var EMAIL = "email"
    var HP = "hp"

    init {
        pref = con.getSharedPreferences(PREF_NAME,0)
        edt = pref?.edit()
    }

    var login : Boolean?
    get() = pref?.getBoolean(ISLOGIN,false)
    set(login) {
        edt?.putBoolean(ISLOGIN, true)
        edt?.commit()
    }
        var nama : String?
        get() = pref?.getString(NAMA,"")
        set(nama) {
            edt?.putString(NAMA,nama)
            edt?.commit()
        }

    var email : String?
        get() = pref?.getString(EMAIL,"")
        set(email) {
            edt?.putString(EMAIL,email)
            edt?.commit()
        }

    var hp : String?
        get() = pref?.getString(HP,"")
        set(hp) {
            edt?.putString(HP,hp)
            edt?.commit()
        }

    fun logout(){
        edt?.clear()
        edt?.commit()
    }
}