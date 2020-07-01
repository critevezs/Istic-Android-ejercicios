package com.example.appparcial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_loguearse.setOnClickListener {

            if (editText_Usuario.text.toString().isEmpty() or editText_contrasena.text.toString()
                    .isEmpty()
            ) {

                Toast.makeText(this, "hay campos sin completar ", Toast.LENGTH_LONG).show()
            } else {

                login_exitoso()

                // finish()
            }

        }

        btn_registrate_del_Login.setOnClickListener {

            val intent_20: Intent = Intent(this, registro::class.java)
            startActivity(intent_20)

            finish()
        }

        btn_sin_registro.setOnClickListener {

            val intent: Intent = Intent(this, datosPersonales::class.java)
            startActivity(intent)

        }
    }

    private fun login_exitoso() {



        try {

            var bandera:String = "no"

            val admin = Admin_Base_de_Datos(this, "SqLite2020", null, 2)
            val bd = admin.writableDatabase

            val usuario: String = editText_Usuario.getText().toString()
            val contrasena: String = editText_contrasena.getText().toString()

            val fila = bd.rawQuery(
                "select nombre,clave from usuarios where nombre='" + usuario + "' and clave='" + contrasena + "'",
                null)

            if (fila.moveToFirst() == true) {

                val usua = fila.getString(0)
                val pass = fila.getString(1)

                if (usuario.equals(usua) && contrasena.equals(pass)) {

                    bandera = "si"


                    val Usuario_Logueado = editText_Usuario.text.toString()

                    val intent: Intent = Intent(this, datosPersonales::class.java)
                    intent.putExtra("nombre", Usuario_Logueado)
                    startActivity(intent)

                    finish()

                }


                   /* if (!(usuario.equals(usua) && contrasena.equals(pass))) {

                        Toast.makeText(
                            this,
                            "usuario y o contraseña incorrecto",
                            Toast.LENGTH_SHORT
                        ).show()
                    }*/

                    if (bandera == "no") {
                        Toast.makeText(
                            this,
                            "usuario y o contraseña incorrecto",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }



            }

        }catch(e: IOException)
            {
                Toast.makeText(this, "debes registrarte", Toast.LENGTH_SHORT).show()
            }

        }


    }


    //me tilda el cel cuando intento logiarme
   /* private fun login_exitoso(usu:String, con:String) {
        val admin = Admin_Base_de_Datos(this, "SqLite2020", null, 2)
        val bd = admin.writableDatabase
        val fila = bd.rawQuery(
            "select nombre,clave from usuarios where nombre='" + usu + "' and clave='" + con + "'",
            null
        )
        while (fila.moveToFirst() == true) {
            val Usua: String = fila.getString(0)
            val pass: String = fila.getString(1)
            if (usu.equals(Usua) && con.equals(pass)) {
                val intent: Intent = Intent(this, datosPersonales::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "usuario y o contraseña incorrecto",  Toast.LENGTH_SHORT).show()
            }


        }
    }*/

    /*private fun login_Exitoso()
    {
        val Usuario_registrado = usuario.retornarArrayUsuarios(contexto = this)
        if (Usuario_registrado[1] == editText_Usuario.text.toString() && Usuario_registrado[2] == editText_contraseña.text.toString())
        {
            val intent: Intent = Intent(this, datosPersonales::class.java)
            startActivity(intent)
        }
        else
        {
            Toast.makeText(this, "usuario y o contraseña incorrecto",  Toast.LENGTH_SHORT).show()
        }
    }*/

/*private fun login_exitoso(){

    val listado=ArrayList<String>()
    val admin = Admin_Base_de_Datos(this, "SqLite2020", null, 2)
    val bd = admin.writableDatabase
    val fila= bd.rawQuery("SELECT nombre,clave from usuarios", null)

    if (fila != null){
        fila.moveToFirst()
        do {
            val Usuario_reg:String = fila.getString(fila.getColumnIndex("nombre"))
            val contrasena_reg:String = fila.getString(fila.getColumnIndex("clave"))
            listado.add(Usuario_reg + contrasena_reg)
        }
            while (fila.moveToNext())
    }

    if (editText_Usuario.text.toString() == listado[0] && editText_contraseña.text.toString() == listado[1] )
    {
        val intent: Intent = Intent(this, datosPersonales::class.java)
        startActivity(intent)

    }else{
        Toast.makeText(this, "No hay Usuarios para listar",  Toast.LENGTH_SHORT).show()
    }



}*/

    /*private fun login_Usuario(){

        val listado=ArrayList<String>()
        try {
            val admin = Admin_Base_de_Datos(this, "SqLite2020", null, 2)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select nombre,clave from usuarios", null)
           if (fila.moveToFirst()) {
                do {
                    val nombre: String = fila.getString(1)
                    val clave: String = fila.getString(2)
                    listado.add( nombre + "," + clave + " \n")
                } while (fila.moveToNext())
            }
                if(listado.equals(editText_Usuario.text.toString()) && listado.equals(editText_contraseña.text.toString())){

                    val intent: Intent = Intent(this, datosPersonales::class.java)
                    startActivity(intent)


                }


            /*else{
                Toast.makeText(this, "No hay Usuarios para listar",  Toast.LENGTH_SHORT).show()
            }*/
            bd.close()

                }catch (e:Throwable)
                {
                    Toast.makeText(this, " usuario y o contraseña incorrecto ${e.message}",  Toast.LENGTH_SHORT).show()
                   // e.message?.let { listado.add(it) }
                 }


    }*/

   /* private fun loginArchivo() {

             (fileList().contains("registro.txt"))
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
            }*/


