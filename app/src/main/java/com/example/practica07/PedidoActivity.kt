package com.example.practica07

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PedidoActivity : AppCompatActivity() {

    private lateinit var edtNombre: EditText
    private lateinit var edtDomicilio: EditText
    private lateinit var edtTelefono: EditText

    private lateinit var spnProductos: Spinner
    private var productoSel: String = "Vampiros"

    private lateinit var spnTallas: Spinner
    private var tallaSel: String = "Chica"

    private var disfraz: Disfraz = Disfraz()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pedido)

        edtNombre = findViewById(R.id.edtNombre)
        edtDomicilio = findViewById(R.id.edtDomicilio)
        edtTelefono = findViewById(R.id.edtTelefono)

        spnProductos = findViewById(R.id.spnProductos)
        val lstProductos = resources.getStringArray(R.array.lstProductos)
        val adaptProductos = ArrayAdapter(this,
            R.layout.spinner_color_selected, lstProductos)
        adaptProductos.setDropDownViewResource(R.layout.spinner_color_dropdown)
        spnProductos.adapter = adaptProductos
        spnProductos.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                p0: AdapterView<*>?, p1: View?, p2:
                Int, p3: Long
            ) {
                productoSel = lstProductos[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spnTallas = findViewById(R.id.spnTallas)
        val lstTallas = resources.getStringArray(R.array.lstTallas)
        val adaptTallas = ArrayAdapter(this,
            R.layout.spinner_color_selected, lstTallas)
        adaptTallas.setDropDownViewResource(R.layout.spinner_color_dropdown)
        spnTallas.adapter = adaptTallas
        spnTallas.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                p0: AdapterView<*>?, p1: View?, p2:
                Int, p3: Long
            ) {
                tallaSel = lstTallas[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }

    fun onClick(view: View?){
        when(view?.id){
            R.id.btnRegistrar -> registrar()
            R.id.btnCancelar -> cancelar()
        }
    }

    private fun registrar() {
        if(edtNombre.text.isNotBlank() && edtNombre.text.isNotEmpty() &&
            edtDomicilio.text.isNotBlank() && edtDomicilio.text.isNotEmpty() &&
            edtTelefono.text.isNotBlank() && edtTelefono.text.isNotEmpty()){

            disfraz.nombre = edtNombre.text.toString()
            disfraz.domicilio = edtDomicilio.text.toString()
            disfraz.producto = productoSel
            disfraz.talla = tallaSel
            disfraz.telefono = edtTelefono.text.toString()


            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("disfraz", disfraz)

            Toast.makeText(this, "Pedido registrado: Disfraz de ${productoSel}", Toast.LENGTH_LONG).show()

            startActivity(intent)
        } else {
            Toast.makeText(this, "Ingresa los datos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun cancelar() {
        finish()
    }
}

