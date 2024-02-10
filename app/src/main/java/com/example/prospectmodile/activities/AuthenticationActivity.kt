package com.example.prospectmodile.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prospectmodile.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class AuthenticationActivity : AppCompatActivity() {

    lateinit var layoutTextInputId : TextInputLayout
    lateinit var layoutTextInputPassword:TextInputLayout
    lateinit var btnConnect : MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        layoutTextInputId =findViewById(R.id.layoutTextInputId)
        layoutTextInputPassword = findViewById(R.id.layoutTextInputPassword)
        btnConnect = findViewById(R.id.btnConnect)

        btnConnect.setOnClickListener {

            layoutTextInputId.isErrorEnabled = false
            layoutTextInputPassword.isErrorEnabled = false

            var id = layoutTextInputId.editText?.text.toString()
            var pwd = layoutTextInputPassword.editText?.text.toString()


            if(id.isEmpty() || pwd.isEmpty()){
                if(pwd.isEmpty()){
                    layoutTextInputPassword.error = "Mot de passe obligatoire!"
                    layoutTextInputPassword.isErrorEnabled = true
                }
                if(id.isEmpty()){
                    layoutTextInputId.error = "Email obligatoire!"
                    layoutTextInputId.isErrorEnabled =  true
                }
            }else{
                signIn(id, pwd)
            }
        }
    }

    fun signIn(id:String,pwd:String){
        if(id == "gest" && pwd == "2323"){
            Intent(this,HomeActivity::class.java).also {
                startActivity(it)
            }
            finish()
        }
        else{
            layoutTextInputPassword.error = "Authentification Echouer!"
            layoutTextInputId.isErrorEnabled = true
            layoutTextInputPassword.isErrorEnabled = true
        }
    }
}