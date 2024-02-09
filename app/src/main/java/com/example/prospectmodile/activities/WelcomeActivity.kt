package com.example.prospectmodile.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.prospectmodile.R

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        //Redirection after waiting time
        Handler(Looper.getMainLooper()).postDelayed(
            {
                Intent(this,AuthenticationActivity::class.java).also { startActivity(it) }
                finish()
            },3000
        )
    }
}