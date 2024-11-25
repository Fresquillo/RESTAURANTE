package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

lateinit var card1: CardView
lateinit var card2: CardView
lateinit var card3: CardView
lateinit var textView: TextView
lateinit var editText: EditText
lateinit var fabUno: FloatingActionButton
lateinit var fabDos: FloatingActionButton
lateinit var izquierda: ImageView
lateinit var fabTres: FloatingActionButton
lateinit var hora: TextView
var asientos: Int = 0
var horas: String = "20:00"

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()
        initListeners()


    }

    fun initComponents() {
        card1 = findViewById(R.id.card1)
        card2 = findViewById(R.id.card2)
        card3 = findViewById(R.id.card3)
        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        fabUno = findViewById(R.id.fabUno)
        fabDos = findViewById(R.id.fabDos)
        fabTres = findViewById(R.id.fabTres)
        hora = findViewById(R.id.hora)
        izquierda = findViewById(R.id.izquierda)
    }

    fun nombre(): String {
        val nombre = editText.text.toString()
        textView.text = nombre
        return editText.text.toString()

    }

    fun initListeners() {
        card1.setOnClickListener {
            card1.setCardBackgroundColor(ContextCompat.getColor(this, R.color.elementoSeleccionado))
            card2.setCardBackgroundColor(ContextCompat.getColor(this, R.color.fondoElementos))
            card3.setCardBackgroundColor(ContextCompat.getColor(this, R.color.fondoElementos))
            asientos = 2


        }
        card2.setOnClickListener {
            card2.setCardBackgroundColor(ContextCompat.getColor(this, R.color.elementoSeleccionado))
            card1.setCardBackgroundColor(ContextCompat.getColor(this, R.color.fondoElementos))
            card3.setCardBackgroundColor(ContextCompat.getColor(this, R.color.fondoElementos))
            asientos = 4



        }
        card3.setOnClickListener {
            card3.setCardBackgroundColor(ContextCompat.getColor(this, R.color.elementoSeleccionado))
            card1.setCardBackgroundColor(ContextCompat.getColor(this, R.color.fondoElementos))
            card2.setCardBackgroundColor(ContextCompat.getColor(this, R.color.fondoElementos))
            asientos = 8


        }

        fabUno.setOnClickListener {
            aumentarHora()


        }

        fabDos.setOnClickListener {
            disminuirHora()
        }

        fabTres.setOnClickListener {
            navigateToResult(nombre(), horas, asientos)

        }
    }



    fun aumentarHora() {
        val horaUno = getString(R.string.hora)
        val horaDos = getString(R.string.horaDos)
        val horaTres = getString(R.string.horaTres)

        if (hora.text.toString() == horaUno) {
            hora.text = horaDos

        } else if (hora.text.toString() == horaDos) {
            hora.text = horaTres
        }
        else if (hora.text.toString() == horaTres) {
            hora.text = horaUno
        }
        else {
            hora.text = horaUno
            horas = hora.text.toString()
        }
        horas = hora.text.toString()


    }

    fun disminuirHora(){
        val horaUno = getString(R.string.hora)
        val horaDos = getString(R.string.horaDos)
        val horaTres = getString(R.string.horaTres)

        if (hora.text.toString() == horaUno) {
            hora.text = horaTres
            horas = hora.text.toString()
        } else if (hora.text.toString() == horaDos) {
            hora.text = horaUno
            horas = hora.text.toString()
        }
        else if (hora.text.toString() == horaTres) {
            hora.text = horaDos
            horas = hora.text.toString()
        }
        else {
            hora.text = horaUno
        }
    }

    fun navigateToResult(nombre: String, horas: String, asientos: Int) {
        val intent = Intent(this, resultado::class.java)
        intent.putExtra("horas", horas)
        intent.putExtra("nombre", nombre)
        intent.putExtra("asientos", asientos)
        startActivity(intent)
    }


}



