package com.project.loginmvpkotlin.View.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.project.loginmvpkotlin.Helper.SessionManager
import com.project.loginmvpkotlin.MainActivity
import com.project.loginmvpkotlin.R
import com.project.loginmvpkotlin.View.Login.Model.DataItem
import com.project.loginmvpkotlin.View.Login.Presenter.LoginPresenter
import com.project.loginmvpkotlin.View.Register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {
    private var presenter : LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this)

        btnLogin.setOnClickListener {
            val email = eEmail.text.toString()
            val password = ePassword.text.toString()
            presenter?.login(email,password)
        }

        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }

    override fun loginSuccess(mgs: String, user: List<DataItem?>) {
        val session = SessionManager(this)
        session.email = user.get(0)?.userEmail
        session.nama = user.get(0)?.userNama
        session.hp = user.get(0)?.userHp
        session.login = true
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun errorLogin(msg: String) {
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
    }
}