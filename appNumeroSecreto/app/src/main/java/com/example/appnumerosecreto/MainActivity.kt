package com.example.appnumerosecreto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val numeroSecreto = (Math.random() *20 ).toInt()
        //val intentos=0

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //textoFijo.text="Comenzando"

        btnVerificar.setOnClickListener {
            // textoFijo.text=txtNombre.text

            //lblNumeroSecreto.text = numeroSecreto.toString()


            //intentos = intentos + 1
           // lblIntentos.text=intentos.toString()

            if(NumeroIngresado.text.toString() <= 0.toString() )
            {
                Toast.makeText(this, "el numero debe ser mayor a cero ", Toast.LENGTH_LONG).show()
            }
            else
            {
                if (numeroSecreto.toString() == NumeroIngresado.text.toString())
                {
                    Toast.makeText(this, "sos un genio adivinaste el numero ", Toast.LENGTH_LONG).show()
                    lblNumeroSecreto.text = numeroSecreto.toString()
                }
                else {
                    if (numeroSecreto.toString() > NumeroIngresado.text.toString())
                    {
                        Toast.makeText(
                            this,
                            "No es el numero , el numero secreto es mayor ",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    else
                    {
                        Toast.makeText(
                            this,
                            "No es el numero , el numero secreto es menor ",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                }
            }

            }

        }
    }
