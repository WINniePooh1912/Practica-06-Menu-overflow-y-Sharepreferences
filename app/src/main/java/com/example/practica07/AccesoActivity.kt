package com.example.practica07

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class AccesoActivity : AppCompatActivity() {

    private lateinit var edtUsuario : EditText
    private lateinit var edtContrasena : EditText

    private lateinit var disfraz : Disfraz

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_acceso)

        edtUsuario = findViewById(R.id.edtUsuario)
        edtContrasena = findViewById(R.id.edtContrasena)

        disfraz = Disfraz()
    }

    fun onClick(view: View?){
        when(view?.id){
            R.id.btnIngresar -> ingresar()
            R.id.btnSalir -> salir()
        }
    }

    private fun ingresar(){
        if(edtUsuario.text.isNotBlank() && edtUsuario.text.isNotEmpty()
            && edtContrasena.text.isNotBlank() && edtContrasena.text.isNotEmpty()){
            val usr = Usuario(edtUsuario.text.toString(), edtContrasena.text.toString(),true)
            guardarPreferencias(usr)

            val intent = Intent(applicationContext,MenuActivity::class.java)
            intent.putExtra("nombre", disfraz.nombre)
            intent.putExtra("domicilio", disfraz.domicilio)
            intent.putExtra("producto", disfraz.producto)
            intent.putExtra("talla", disfraz.talla)
            intent.putExtra("telefono", disfraz.telefono)
            startActivity(intent)
        }else{
            Toast.makeText(this,"Llena los campos vacios",Toast.LENGTH_LONG).show()
        }
    }

    private fun guardarPreferencias(user:Usuario){
        val preferences : SharedPreferences = getSharedPreferences("preferenciasUsuario",
            MODE_PRIVATE)

        val editor : SharedPreferences.Editor = preferences.edit()
        editor.putString("usuario",user.usuario)
        editor.putString("password",user.contrasena)
        editor.putBoolean("guardado",user.guardado)

        editor.apply()
    }

    private fun salir(){
        this.finish()
        exitProcess(0)
    }
}
