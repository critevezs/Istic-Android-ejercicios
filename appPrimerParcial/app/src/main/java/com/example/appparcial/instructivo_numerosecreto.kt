package com.example.appparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_instructivo_numerosecreto.*

class instructivo_numerosecreto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instructivo_numerosecreto)

        val usuario_4=intent.getStringExtra("nombre_3");


        btn_comenzar.setOnClickListener {

            val Usuario_Logueado_4 = usuario_4
            val intent9: Intent = Intent (this, numeroSecreto::class.java)
            intent9.putExtra("nombre_4", Usuario_Logueado_4)
            startActivity(intent9)

            finish()


        }


    }
}
