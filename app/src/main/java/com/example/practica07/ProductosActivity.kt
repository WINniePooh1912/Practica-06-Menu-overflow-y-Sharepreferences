package com.example.practica07

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProductosActivity : AppCompatActivity() {
    private lateinit var ltvProductos: ListView
    private var productoSel: String = "Vampiros"

    private var info = ""

    private var disfraz: Disfraz = Disfraz()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_productos)

        disfraz = intent.getParcelableExtra<Disfraz>("disfraz") ?: Disfraz()

        ltvProductos = findViewById(R.id.ltvProductos)

        val prods = resources.getStringArray(R.array.lstProductos)
        val adpProds = ArrayAdapter(this,R.layout.spinner_color_selected,prods)
        ltvProductos.adapter = adpProds
        ltvProductos.setOnItemClickListener { parent,view,position,id->
            productoSel = parent.getItemAtPosition(position).toString()
            parent.getItemAtPosition(position)
            when(position){
                0 -> info = "Cómodo, Talla: Chica y Grande, Precio: $500"
                1 -> info = "Modelo reducido, Talla: Mediana y Grande, Precio: $800"
                2 -> info = "Accesorios incluidos, Talla: Chica y Mediana, Precio: $400"
                3 -> info = "No incluye un traje para mascota, Talla: Chica, Precio: $100"
                4 -> info = "Gratis un collar de perlas, Talla: Chica, Mediana y Grande, Precio: $700"
            }
            Toast.makeText(this,"Producto: ${productoSel} || ${info} ",Toast.LENGTH_LONG).show() }
    }
    fun regresar (view: View?){
        when(view?.id){
            R.id.btnRegresar -> finish()
        }
    }
}