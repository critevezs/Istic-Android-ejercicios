package com.example.appparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_listado__usuarios.*

class Listado_Usuarios : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado__usuarios)

        listarUsuarios()


    }

     fun listarUsuarios()
    {
        val listado=ArrayList<String>()
        try {
            val admin = Admin_Base_de_Datos(this, "SqLite2020", null, 2)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select id,nombre,clave from usuarios", null)
            if (fila.moveToFirst()) {
                do {
                    val id: String = fila.getString(0)
                    val nombre: String = fila.getString(1)
                    val clave: String = fila.getString(2)
                    listado.add(id +","+nombre+","+clave+" \n")
                } while (fila.moveToNext())
            } else{
                Toast.makeText(this, "No hay Usuarios para listar",  Toast.LENGTH_SHORT).show()
            }
            bd.close()
            val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listado)
            this.Listado_Visor.adapter=adapter
        }catch (e:Throwable)
        {
            Toast.makeText(this, "No hay artículo ${e.message}",  Toast.LENGTH_SHORT).show()
            e.message?.let { listado.add(it) }
        }

    }
}
