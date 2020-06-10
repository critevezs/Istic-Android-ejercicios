package com.example.appparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_historial__contador.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class Historial_Contador : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial__contador)

        btn_volver_historial_contador.setOnClickListener {

            val intent_24: Intent = Intent (this,contador::class.java)
            startActivity(intent_24)

            finish()
        }

        CargarListado()

    }

    private fun CargarListado()
    {
        if (fileList().contains("datos.txt")) {
            try {
                val archivo = InputStreamReader(openFileInput("datos.txt"))
                val br = BufferedReader(archivo)
                var linea = br.readLine()
                val listado = StringBuilder()//solo para mostrarlo
                while (linea != null) {
                    listado.append(linea + " \n ")
                    linea = br.readLine()
                }
                br.close()
                archivo.close()
                this.editText_historial_contador.setText(listado)
            } catch (e: IOException) {
            }
        }

    }
}
