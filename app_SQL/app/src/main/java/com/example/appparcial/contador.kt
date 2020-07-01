package com.example.appparcial

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_contador.*
import java.io.IOException
import java.io.OutputStreamWriter

class contador : AppCompatActivity() {

    var cont: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contador)


        btn_volver.setOnClickListener {

            val intent_3: Intent = Intent(this, juegos::class.java)

            startActivity(intent_3)

            finish()
        }


        btn_contar.setOnClickListener {

            cont = cont + 1
            textView_cuenta.text = cont.toString()

        }

        btn_reset.setOnClickListener {

            cont = 0
            textView_cuenta.text = " "
            //val intent_9:Intent = Intent (this, contador::class.java)
            //startActivity(intent_9)

            //finish()

        }

        btn_historial_contador.setOnClickListener {

            val intent_21: Intent = Intent(this, Historial_Contador::class.java)

            startActivity(intent_21)

            finish()

        }

        btn_Guardar_Contador.setOnClickListener {


            try {
                val archivo = OutputStreamWriter(openFileOutput("datos.txt", Activity.MODE_APPEND))
                archivo.write(editText_Obj_Contador.text.toString() + "  " + textView_cuenta.text.toString() + "\n")
                archivo.flush()
                archivo.close()
            } catch (e: IOException) {

            }
            Toast.makeText(this, "Guardando...", Toast.LENGTH_SHORT).show()

        }

    }
}

   /* private fun GuardarEnSqLite() {
        try {
            val admin = Admin_Base_de_Datos(this,"SqLite2020", null, 2)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("descripcion",textView_cuenta.text.toString())
            registro.put("intentos",editText_Obj_Contador.text.toString())
            registro.put("jugador",Usuario_Logueado_2)
            bd.insert("jugadas", null, registro)
            bd.close()
            //esto lo comento para que no salga este mensaje en el registro
            //Toast.makeText(contexto, "se creo el ID: $retorno", Toast.LENGTH_SHORT).show()
        }catch (e:Throwable)
        {
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }

    }*/

