package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

lateinit var resultadoCita: TextView


class resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initUI()


    }

    fun initComponents() {
        resultadoCita = findViewById(R.id.resultadoCita)
    }

    fun initUI(){
        val nombre = intent.getStringExtra("nombre")
        val hora = intent.getStringExtra("horas")
        val asientos = intent.getIntExtra("asientos", 0)
        resultadoCita.text = getString(R.string.cita, nombre, hora, asientos)

    }










}