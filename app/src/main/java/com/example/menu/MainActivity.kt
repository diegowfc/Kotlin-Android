package com.example.menu

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var cont = 0
    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtResultado = findViewById(R.id.txtResultado)
        txtResultado.text = "$cont"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.opcoes, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.mnuIncrementar)
            cont++
        else if(item.itemId == R.id.mnuDecrementar && cont > 0)
            cont--
        else if(item.itemId == R.id.mnuDecrementar && cont == 0)
            Toast.makeText(this,"Não é possível decrementar de 0", Toast.LENGTH_SHORT).show()
        else if(item.itemId == R.id.mnuReiniciar)
            cont = 0;
        else if(item.itemId == R.id.mnuFechar)
            finish()
        else
            return super.onOptionsItemSelected(item)

        txtResultado.text = "$cont"
        return true
    }
}