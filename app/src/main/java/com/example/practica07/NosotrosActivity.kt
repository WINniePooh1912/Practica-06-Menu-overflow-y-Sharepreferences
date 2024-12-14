package com.example.practica07

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NosotrosActivity : AppCompatActivity() {

    private var disfraz: Disfraz = Disfraz()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nosotros)

        disfraz = intent.getParcelableExtra<Disfraz>("disfraz") ?: Disfraz()
    }

    fun regresar (view: View?){
        when(view?.id){
            R.id.btnRegresar -> finish()
        }
    }
}