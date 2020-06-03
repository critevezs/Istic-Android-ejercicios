package com.example.appparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.activity_registro__ok.*

class Registro_Ok : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro__ok)


        btn_Iniciar_sesion.setOnClickListener {

            val intent_16:Intent = Intent (this,MainActivity::class.java)
            startActivity(intent_16)

            finish()
        }
    }
}
