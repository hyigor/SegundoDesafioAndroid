package br.com.digitalhouse.segundodesafiokotlin.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.digitalhouse.segundodesafiokotlin.R
import android.widget.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        saveButton.setOnClickListener{
            callMain()
        }

        toolbarconfiguracoes.setNavigationOnClickListener{
            finish()
        }


    }
    fun callMain(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }



}