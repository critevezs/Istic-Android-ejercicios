package com.example.appparcial

import android.app.Activity
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_datos_personales.*
import java.io.IOException
import java.io.OutputStreamWriter
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class datosPersonales : AppCompatActivity() {


   // @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_personales)

        val usuario=intent.getStringExtra("nombre");
        val Usuario_Logueado_2 = usuario

       //val fecha = LocalDate.now().

        val currentDate:String = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())

       val currentTime:String = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())


        btn_juegos.setOnClickListener {


            try {
                val archivo = OutputStreamWriter(openFileOutput("datos.txt", Activity.MODE_APPEND))
                archivo.write("Usuario: "  + Usuario_Logueado_2 + "  " + "fecha: " + currentDate + " " +  "Hora: " + currentTime  +"\n")
                archivo.flush()
                archivo.close()
            } catch (e: IOException) {

            }

            try {
                val archivo = OutputStreamWriter(openFileOutput("datos_numero.txt", Activity.MODE_APPEND))
                archivo.write("Usuario: "  + Usuario_Logueado_2 + "  " + "fecha: " + currentDate + " " + "Hora " + currentTime  +"\n")
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
