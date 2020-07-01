package com.example.appparcial

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_historial__contador.*
import kotlinx.android.synthetic.main.activity_listado__usuarios.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class Historial_Contador : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial__contador)

        btn_volver_historial_contador.setOnClickListener {

            val intent_24: Intent = Intent(this, contador::class.java)
            startActivity(intent_24)

            finish()
        }

        CargarListado()

    }


    private fun CargarListado() {
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

    /*fun listarUsuarios()
    {
        val listado=ArrayList<String>()
        try {
            val admin = Admin_Base_de_Datos(this, "SqLite2020", null, 2)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select jugador, descripcion,cantidad from jugadas", null)
            if (fila.moveToFirst()) {
                do {
                    val jugador: String = fila.getString(0)
                    val descripcion: String = fila.getString(1)
                    val cantidad: String = fila.getString(2)
                    listado.add(jugador +","+descripcion+","+cantidad+" \n")
                } while (fila.moveToNext())
            } else{
                Toast.makeText(this, "No hay jugadas para guardar",  Toast.LENGTH_SHORT).show()
            }
            bd.close()
            val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listado)
            this.Listado_Visor.adapter=adapter
        }catch (e:Throwable)
        {
            Toast.makeText(this, "No hay artículo ${e.message}",  Toast.LENGTH_SHORT).show()
            e.message?.let { listado.add(it) }
        }

    }*/

