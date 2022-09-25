package com.example.room


import Beans.Usuarios
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import dataBase.appDataBase


class MainActivity : AppCompatActivity() {
    var txtNom: EditText? = null
    var txtCorreo:EditText? = null
    var txtPas:EditText? = null
    var btnGrabar: Button? = null
    var btnListar:Button? = null
    var txtRes: TextView? = null

    var lista: List<Usuarios>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtCorreo = findViewById(R.id.txtCorreo)
        txtNom = findViewById(R.id.txtNom)
        txtPas = findViewById(R.id.txtPass)
        btnGrabar = findViewById(R.id.btnGrabar)
        btnListar = findViewById(R.id.btnListar)
        txtRes = findViewById(R.id.txtRes)
        val db = appDataBase.getInstance(this.applicationContext)
        val dao = db!!.usuariosDAO()
        btnGrabar.setOnClickListener(View.OnClickListener {
            val usuario = Usuarios()
            usuario.nombre = txtNom!!.text.toString()
            usuario.correo = txtCorreo!!.text.toString()
            usuario.pass = txtPas!!.text.toString()
            if (dao != null) {
                dao.insert(usuario)
            }
        })
        btnListar.setOnClickListener(View.OnClickListener {
            lista = dao!!.listaUsuarios()
            val can = lista!!.size
            txtRes.setText("Cantidad de Registros: $can\n")
            for (i in lista!!.indices) {
                val u = lista!![i]
                txtRes.append(
                    """
                    
                    Codigo: ${u.id}
                    Nombre: ${u.nombre}
                    Correo: ${u.correo}
                    Password: ${u.pass}
                    
                    """.trimIndent()
                )
            }
        })
    }
}