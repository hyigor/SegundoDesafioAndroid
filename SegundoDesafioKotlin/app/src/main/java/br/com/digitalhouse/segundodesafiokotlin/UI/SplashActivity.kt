package br.com.digitalhouse.segundodesafiokotlin.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.digitalhouse.segundodesafiokotlin.R
import kotlinx.coroutines.*


class SplashActivity : AppCompatActivity() {
    val scope = CoroutineScope(Dispatchers.Main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashCoroutine()
    }


    fun splashCoroutine() {
        val intent = Intent(this, LoginActivity::class.java)
        scope.launch {
            delay(2000)
            startActivity(intent)
            finish()
        }
    }
}