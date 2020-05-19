package com.example.appparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_datos_personales.*

class datosPersonales : AppCompatActivity() {

   // val Nom="Cristian"
    //val Apell="Nuñez"
   // val Legajo="123456"
   // val Github="https://github.com/critevezs"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_personales)




        btn_juegos.setOnClickListener {

            val intent_2:Intent = Intent (this, juegos::class.java)
            startActivity(intent_2)

            finish()

        }


    }
}
