package com.example.appparcial

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contador.*

class contador : AppCompatActivity() {

    var cont:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contador)


        btn_volver.setOnClickListener {

            val intent_3:Intent = Intent (this, juegos::class.java)
            startActivity(intent_3)

            finish()
        }


        btn_contar.setOnClickListener {

            cont= cont + 1
            textView_cuenta.text= cont.toString()

        }

        btn_reset.setOnClickListener {


            val intent_9:Intent = Intent (this, contador::class.java)
            startActivity(intent_9)

            finish()

        }







    }
}
