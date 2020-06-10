package com.example.appparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registro.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_loguearse.setOnClickListener {

            if (editText_Usuario.text.toString().isEmpty() or editText_contraseña.text.toString().isEmpty()){

                Toast.makeText(this, "hay campos sin completar ", Toast.LENGTH_LONG).show()
           }
            else {

               loginArchivo( )

                finish()
            }

        }

        btn_registrate_del_Login.setOnClickListener {

            val intent_20:Intent = Intent (this,registro::class.java)
            startActivity(intent_20)

            finish()

        }

    }

    private fun loginArchivo() {

            if (fileList().contains("registro.txt")) {
                try {

                    var bandera: String = "no"

                    val archivo = InputStreamReader(openFileInput("registro.txt"))
                    val br = BufferedReader(archivo)
                    var linea = br.readLine()
                    while (linea != null) {

                        val arrayDatos = linea.split("=>")
                        if (arrayDatos[0] == editText_Usuario.text.toString() && arrayDatos[1] == editText_contraseña.text.toString()) {

                            bandera = "si"
                            val Usuario_Logueado = editText_Usuario.text.toString()
                            val intent: Intent = Intent(this, datosPersonales::class.java)

                            intent.putExtra("nombre", Usuario_Logueado)
                            startActivity(intent)
                            break

                        }
                        /*if(arrayDatos[0] != editText_Usuario.text.toString()){
                            bandera="no"
                            Toast.makeText(this, "Usuario incorecto ", Toast.LENGTH_LONG).show()
                            break
                        }
                        else{
                            if(arrayDatos[1] != editText_contraseña.text.toString()){
                                bandera="no"
                                Toast.makeText(this, "contraseña incorecto ", Toast.LENGTH_LONG).show()
                                break
                            }
                        }*/

                        linea = br.readLine()
                    }

                    if (bandera == "no") {
                        Toast.makeText(this, "Usuario y/o contraseña incorecto ", Toast.LENGTH_LONG).show()

                   }

                    br.close()
                    archivo.close()

                } catch (e: IOException) {

                    Toast.makeText(this, "el Usuario no exite, REGISTRATE ", Toast.LENGTH_LONG).show()

                }
            }

        }
    }

