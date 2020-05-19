package com.example.appparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_loguearse.setOnClickListener {

            if (editText_Usuario.text.toString().isEmpty() or editText_contraseña.text.toString().isEmpty()){

                Toast.makeText(this, "hay campos sin completar ", Toast.LENGTH_LONG).show()
            }
            else {

                val intent: Intent = Intent(this, datosPersonales::class.java)
                startActivity(intent)

                finish()
            }

        }

    }




}
