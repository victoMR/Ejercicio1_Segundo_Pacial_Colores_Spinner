package com.example.ejercicio1segundopacialv2

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //atributos
    private lateinit var spColores: Spinner
    private lateinit var tvMensaje: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // inicializar atributos
        spColores = findViewById(R.id.spColores)
        tvMensaje = findViewById(R.id.tvMensaje)

        // declaramos el arreglo con los colores
        val colores = arrayOf("Selciona un color","Rojo","Amarillo","Azul ","Verde","Morado","Negro")

        //dependiendo de el color que eligamos el text view se cambiara el color selecionado por el usuario
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,colores)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spColores.adapter = adapter

        spColores.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                if ( position == 0){
                    tvMensaje.text=""
                }else if (position == 1){
                    tvMensaje.text="Rojo"
                    tvMensaje.setTextColor(Color.RED)
                }else if (position == 2){
                    tvMensaje.text="Amarillo"
                    tvMensaje.setTextColor(Color.YELLOW)
                }else if (position == 3){
                    tvMensaje.text="Azul"
                    tvMensaje.setTextColor(Color.BLUE)
                }else if (position == 4){
                    tvMensaje.text="Verde"
                    tvMensaje.setTextColor(Color.GREEN)
                }else if (position == 5){
                    tvMensaje.text="Morado"
                    tvMensaje.setTextColor(Color.MAGENTA)
                }else{
                    tvMensaje.text="Negro"
                    tvMensaje.setTextColor(Color.BLACK)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                tvMensaje.text="None"
            }

        }
    }
}