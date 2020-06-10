package com.example.appparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.activity_juegos.*

class juegos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juegos)


        btn_contador.setOnClickListener {

            val intent5:Intent = Intent (this, instructivo_contador::class.java)

            startActivity(intent5)

            finish()

        }

        btn_numSecreto.setOnClickListener {

            val intent6:Intent = Intent (this, instructivo_numerosecreto::class.java)

            startActivity(intent6)

            finish()

        }

        btn_IraPerfil.setOnClickListener {

            val intent13:Intent = Intent (this,datosPersonales::class.java)

            startActivity(intent13)

            finish()

        }


    }
}
