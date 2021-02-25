package com.project.loginmvpkotlin.View.SplashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.project.loginmvpkotlin.Helper.SessionManager
import com.project.loginmvpkotlin.MainActivity
import com.project.loginmvpkotlin.R
import com.project.loginmvpkotlin.View.Login.LoginActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        val session = SessionManager(this)
        Handler().postDelayed( Runnable {
            if(session.login ?: true){
                startActivity(Intent(this, MainActivity::class.java))
            }else{
                startActivity(Intent(this,LoginActivity::class.java))
            }

            finish()
        },2000 )
    }
}