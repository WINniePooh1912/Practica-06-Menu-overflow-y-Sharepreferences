package com.example.practica07

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {
    private lateinit var intent: Intent
    private lateinit var disfraz: Disfraz

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        disfraz = Disfraz()

        Timer().schedule(object : TimerTask() {
            override fun run() {
                intent = if (nuevoUsuario()) {
                    Intent(applicationContext, MenuActivity::class.java)
                    intent.putExtra("nombre", disfraz.nombre)
                    intent.putExtra("domicilio", disfraz.domicilio)
                    intent.putExtra("producto", disfraz.producto)
                    intent.putExtra("talla", disfraz.talla)
                    intent.putExtra("telefono", disfraz.telefono)
                } else {
                    Intent(applicationContext, AccesoActivity::class.java)
                }
                startActivity(intent)
            }
        }, 2000)
    }

    fun nuevoUsuario(): Boolean {
        val preferences: SharedPreferences = getSharedPreferences("preferenciasUsuario", MODE_PRIVATE)
        return preferences.getBoolean("guardado", false)
    }
}