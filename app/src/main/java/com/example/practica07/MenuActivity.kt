package com.example.practica07

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatActivity.MODE_PRIVATE
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    private lateinit var disfraz: Disfraz

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        disfraz = intent.getParcelableExtra<Disfraz>("disfraz") ?: Disfraz()
    }

    // Inflar el menú overflow
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overflow, menu)
        return true
    }

    // Manejar clics en los ítems del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent: Intent?
        when (item.itemId) {
            R.id.pedido -> {
                intent = Intent(applicationContext, PedidoActivity::class.java)
                intent.putExtra("disfraz", disfraz)
                startActivity(intent)
            }
            R.id.productos -> {
                intent = Intent(applicationContext, ProductosActivity::class.java)
                intent.putExtra("disfraz", disfraz)
                startActivity(intent)
            }
            R.id.mis_compras -> {
                intent = Intent(applicationContext, ComprasActivity::class.java)
                intent.putExtra("disfraz", disfraz)
                startActivity(intent)
            }
            R.id.nosotros -> {
                intent = Intent(applicationContext, NosotrosActivity::class.java)
                intent.putExtra("disfraz", disfraz)
                startActivity(intent)
            }
            R.id.cerrar_sesion -> { cerrarSesion() }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun cerrarSesion() {
        val editor = getSharedPreferences("preferenciasUsuario", MODE_PRIVATE).edit()
        editor.clear()
        editor.apply()

        val intent = Intent(applicationContext, AccesoActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP;Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)

        finish()
    }
}