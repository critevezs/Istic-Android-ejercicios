package com.example.appparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_historial__numero__secreto.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class Historial_Numero_Secreto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial__numero__secreto)

        btn_Volver_Numero_Secreto.setOnClickListener {

            val intent_25: Intent = Intent (this,numeroSecreto::class.java)
            startActivity(intent_25)

            finish()
        }

        CargarListado()

    }

    private fun CargarListado()
    {
        if (fileList().contains("datos_numero.txt")) {
            try {
                val archivo = InputStreamReader(openFileInput("datos_numero.txt"))
                val br = BufferedReader(archivo)
                var linea = br.readLine()
                val listado = StringBuilder()//solo para mostrarlo
                while (linea != null) {
                    listado.append(linea + " \n ")
                    linea = br.readLine()
                }
                br.close()
                archivo.close()
                this.editText_Historial_Secreto.setText(listado)
            } catch (e: IOException) {
            }
        }

    }


}
