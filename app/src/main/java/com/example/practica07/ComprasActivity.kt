package com.example.practica07

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ComprasActivity : AppCompatActivity() {

    private lateinit var info : TextView
    private var disfraz: Disfraz = Disfraz()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_compras)

        info = findViewById(R.id.txtInfo)

        disfraz = intent.getParcelableExtra<Disfraz>("disfraz") ?: Disfraz()

        // Verificar si el objeto 'costume' tiene datos
        if (disfraz.nombre != "none") {
            info.text = "\tNombre: \t${disfraz.nombre}\n" +
                    "\tDomicilio: \t${disfraz.domicilio}\n" +
                    "\tProducto: \t${disfraz.producto}\n" +
                    "\tTalla: \t${disfraz.talla}\n" +
                    "\tTeléfono: \t${disfraz.telefono}\n"
        } else {
            info.text = "Sin pedidos"
        }
    }

    fun regresar (view: View?){
        when(view?.id){
            R.id.btnRegresar -> finish()
        }
    }
}