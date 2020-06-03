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

               loginArchivo(editText_Usuario.text.toString(),editText_contraseña.text.toString() )


                //val intent: Intent = Intent(this, datosPersonales::class.java)
                //startActivity(intent)

                finish()
            }

        }

        btn_registrate_del_Login.setOnClickListener {

            val intent_20:Intent = Intent (this,registro::class.java)
            startActivity(intent_20)

            finish()

        }

    }

    private fun loginArchivo(Usu_log:String , Con_log:String)
    {
        if (fileList().contains("registro.txt")) {
            try {
                val archivo = InputStreamReader(openFileInput("registro.txt"))
                val br = BufferedReader(archivo)
                var linea = br.readLine()
                while (linea != null) {

                    val arrayDatos=linea.split("=>")
                    if(arrayDatos[0]== Usu_log && arrayDatos[1]==Con_log)
                    {
                        val intent: Intent = Intent(this, datosPersonales::class.java)

                        //intento pasaje datos
                        //intent.putExtra("nombre",Usu_log.toString())
                        startActivity(intent)

                    }
                    //else
                   //{
                        //Toast.makeText(this, "Usuario y/o contraseña incorecto ", Toast.LENGTH_LONG).show()


                  // }
                    linea = br.readLine()
                }


                br.close()
                archivo.close()

            } catch (e: IOException) {
                Toast.makeText(this, "Usuario y/o contraseña incorecto ", Toast.LENGTH_LONG).show()
            }
        }

    }

}
