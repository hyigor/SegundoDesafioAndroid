package br.com.digitalhouse.segundodesafiokotlin.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.digitalhouse.segundodesafiokotlin.R
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        createButton.setOnClickListener{
            callRegister()
        }
        loginButton.setOnClickListener{
            callMain()
        }
    }


    fun callRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    fun callMain(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}


