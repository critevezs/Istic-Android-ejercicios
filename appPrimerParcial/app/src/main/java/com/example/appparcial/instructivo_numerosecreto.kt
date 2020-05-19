package com.example.appparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_instructivo_numerosecreto.*

class instructivo_numerosecreto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instructivo_numerosecreto)


        btn_comenzar.setOnClickListener {

           val intent9: Intent = Intent (this, numeroSecreto::class.java)
            startActivity(intent9)

            finish()


        }


    }
}
