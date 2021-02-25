package com.project.loginmvpkotlin.View.Register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.project.loginmvpkotlin.View.Login.LoginActivity
import com.project.loginmvpkotlin.R
import com.project.loginmvpkotlin.View.Register.Model.RegisterResponse
import com.project.loginmvpkotlin.View.Register.Presenter.RegisterPresenter
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterView {
    private var presenter : RegisterPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        presenter = RegisterPresenter(this)

        btnSignUp.setOnClickListener {
            val nama = eNama.text.toString()
            val email = eEmail.text.toString()
            val hp = eHp.text.toString()
            val password = ePassword.text.toString()
            val passwordConfirm = ePasswordConfrim.text.toString()
            presenter?.register(nama, hp, email, password, passwordConfirm)

        }
    }

    override fun successRegister(response: RegisterResponse) {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun errorRegister(msg: String) {
        showToast(msg)
    }

    override fun empty() {
        showToast("tidak boleh ada yang kosong")
    }

    override fun noMatch() {
        showToast("password tidak cocok")
    }

    override fun startProgressBar() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progress.visibility = View.INVISIBLE
    }

    fun showToast(msg : String){
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
    }
}