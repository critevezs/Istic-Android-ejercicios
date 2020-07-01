package com.example.appparcial

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registro.*
import java.io.IOException
import java.io.OutputStreamWriter

class registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        btn_registrarse.setOnClickListener {


            if (lbl_Nombre_Usuario.text.toString()
                    .isEmpty() or lbl_Registro_Contrasena.text.toString()
                    .isEmpty() or lbl_Repetir_Contrasena.text.toString().isEmpty()
            ) {

                Toast.makeText(this, "hay campos sin completar ", Toast.LENGTH_LONG).show()
            } else {
                if (lbl_Registro_Contrasena.text.toString() != lbl_Repetir_Contrasena.text.toString()) {

                    Toast.makeText(this, "las contraseñas son diferentes ", Toast.LENGTH_LONG)
                        .show()
                } else {

                   /* registrarUsuario(
                        lbl_Nombre_Usuario.text.toString(),
                        lbl_Registro_Contrasena.text.toString()
                    )*/
                    altaDeUsuario()

                    //val intent_17: Intent = Intent(this, Registro_Ok::class.java)
                    //startActivity(intent_17)

                    //finish()
                }
            }
        }
    }


    private fun altaDeUsuario(): Long {
        var retorno:Long= 0L
        //Toast.makeText(this, "btnAltaUsuario", Toast.LENGTH_SHORT).show()
        if(this.lbl_Nombre_Usuario.toString().isNotEmpty()&&this.lbl_Registro_Contrasena.toString().isNotEmpty() )
        {

            var nombre=this.lbl_Nombre_Usuario.getText().toString()
            var clave=this.lbl_Registro_Contrasena.getText().toString()
            val miUsuario= usuario(nombre,clave)
            retorno=miUsuario.GuardarEnSqLite(this)

            val intent_17: Intent = Intent(this, Registro_Ok::class.java)


            startActivity(intent_17)

            finish()


            /*
            try {
                val admin = Admin_baseDeDatos(this,"SqLite2020", null, 2)
                val bd = admin.writableDatabase
                val registro = ContentValues()
                registro.put("nombre",nombre)
                registro.put("clave",clave)
                val newId=bd.insert("usuarios", null, registro)
                retorno= newId
                bd.close()
                Toast.makeText(this, "se creo el ID: $newId", Toast.LENGTH_SHORT).show()
            }catch (e:Throwable)
            {
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }

             */
        }else
        {
            Toast.makeText(this, "Los campos no deben estar vacios", Toast.LENGTH_SHORT).show()
        }
        return retorno
    }


    /*private fun registrarUsuario(Usu:String , Con:String)
    {

        try {
           val archivo = OutputStreamWriter(openFileOutput("registro.txt", Activity.MODE_APPEND))
            archivo.write(Usu + "=>" + Con + "\n")
           archivo.flush()
            archivo.close()
       } catch (e: IOException) {

        }
    }*/
}
