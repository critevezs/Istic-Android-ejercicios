package com.example.appparcial

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registro.*
import java.io.IOException
import java.io.OutputStreamWriter

class registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        btn_registrarse.setOnClickListener {


            if (lbl_Nombre_Usuario.text.toString()
                    .isEmpty() or lbl_Registro_Contrasena.text.toString()
                    .isEmpty() or lbl_Repetir_Contrasena.text.toString().isEmpty()
            ) {

                Toast.makeText(this, "hay campos sin completar ", Toast.LENGTH_LONG).show()
            } else {


                registrarUsuario(lbl_Nombre_Usuario.text.toString(),lbl_Registro_Contrasena.text.toString())

                val intent_17: Intent = Intent(this, Registro_Ok::class.java)
                startActivity(intent_17)


                finish()

            }
        }



    }


    private fun registrarUsuario(Usu:String , Con:String)
    {

        try {
           val archivo = OutputStreamWriter(openFileOutput("registro.txt", Activity.MODE_APPEND))
            archivo.write(Usu + "=>" + Con + "\n")
           archivo.flush()
            archivo.close()
       } catch (e: IOException) {

        }
    }

}
