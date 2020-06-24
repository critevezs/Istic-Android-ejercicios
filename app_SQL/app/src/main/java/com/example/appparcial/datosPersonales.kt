package com.example.appparcial

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_datos_personales.*
import java.io.IOException
import java.io.OutputStreamWriter
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class datosPersonales : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_personales)

        val usuario=intent.getStringExtra("nombre");
        val Usuario_Logueado_2 = usuario

       val fecha = LocalDate.now()
       /* val localDate:LocalDate = LocalDate.now()
        val dateTimeFormatter:DateTimeFormatter = DateTimeFormatter.ofPattern("dd,mm,yyyy")
        val fecha = localDate.format(dateTimeFormatter)*/

        btn_juegos.setOnClickListener {


            try {
                val archivo = OutputStreamWriter(openFileOutput("datos.txt", Activity.MODE_APPEND))
                archivo.write("Usuario: "  + Usuario_Logueado_2 + "  " + "fecha: " + fecha + "\n")
                archivo.flush()
                archivo.close()
            } catch (e: IOException) {

            }

            try {
                val archivo = OutputStreamWriter(openFileOutput("datos_numero.txt", Activity.MODE_APPEND))
                archivo.write("Usuario: "  + Usuario_Logueado_2 + "  " + "fecha: " + fecha +  "\n")
                archivo.flush()
                archivo.close()
            } catch (e: IOException) {

            }

            val intent_2:Intent = Intent (this, juegos::class.java)

            startActivity(intent_2)

            finish()

        }
    }
}
