package com.example.appparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contador.*
import kotlinx.android.synthetic.main.activity_instructivo_contador.*

class instructivo_contador : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instructivo_contador)

        val usuario=intent.getStringExtra("nombre");
        val Usuario_Logueado_2 = usuario


        btn_comenzar.setOnClickListener {


            val intent8:Intent = Intent (this,contador::class.java)
            intent8.putExtra("nombre", Usuario_Logueado_2) //agregie
            startActivity(intent8)

            finish()

        }


    }
}
