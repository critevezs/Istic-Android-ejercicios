package com.example.appparcial

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent

import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


import kotlinx.android.synthetic.main.activity_numero_secreto.*
import java.io.IOException
import java.io.OutputStreamWriter

class numeroSecreto : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numero_secreto)

        val numeroSecreto = (Math.random() *50 ).toInt()
        var intentos:Int = 0


        btn_volver.setOnClickListener {

            val intent4:Intent = Intent (this, juegos::class.java)
            startActivity(intent4)

            finish()
        }

        btn_Historial_Numero.setOnClickListener {

          val intent_26:Intent = Intent (this,Historial_Numero_Secreto::class.java)
            startActivity(intent_26)

            finish()

        }


        btn_reintentar.setOnClickListener {

            val intent11: Intent = Intent (this,com.example.appparcial.numeroSecreto::class.java)
            startActivity(intent11)

            finish()

        }

        btn_rendirse.setOnClickListener {

            textView_random.text=numeroSecreto.toString()
            Toast.makeText(this, "por que te rendiste no era tan dificil el numero era $numeroSecreto ", Toast.LENGTH_LONG).show()

        }

        btn_verificar.setOnClickListener {

            intentos=intentos+1
            textView_intentos.text=intentos.toString()

            if (editText_ingreso.text.toString().isEmpty() ){

                Toast.makeText(this, "debe igresar un numero ", Toast.LENGTH_LONG).show()
            }
            else{
                if (editText_ingreso.text.toString() <= 0.toString() ){

                    Toast.makeText(this, "el numero debe ser mayor a 0 ", Toast.LENGTH_LONG).show()
                }
                else{
                    if (editText_ingreso.text.toString() > 50.toString()){

                        Toast.makeText(this, "el numero debe ser menor a 50 ", Toast.LENGTH_LONG).show()
                    }
                    else{
                        if (numeroSecreto.toString() == editText_ingreso.text.toString()){
                            Toast.makeText(this, "sos un genio adivinaste el numero secreto", Toast.LENGTH_LONG).show()
                             textView_random.text=numeroSecreto.toString()

                            try {
                                val archivo = OutputStreamWriter(openFileOutput("datos_numero.txt", Activity.MODE_APPEND))

                                archivo.write(   "Intentos: " + " " + intentos.toString() + "\n")
                                archivo.flush()
                                archivo.close()
                            } catch (e: IOException) {

                            }
                        }
                    else{
                            if (numeroSecreto.toString() > editText_ingreso.text.toString()){

                                Toast.makeText(this, "el numero secreto es mayor ", Toast.LENGTH_LONG).show()
                            }
                            else{
                                if (numeroSecreto.toString() < editText_ingreso.text.toString()){

                                    Toast.makeText(this, "el numero secreto es menor ", Toast.LENGTH_LONG).show()
                                }
                            }

                            }
                    }
                }
            }
        }
    }
}
