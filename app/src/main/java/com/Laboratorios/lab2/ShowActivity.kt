package com.Laboratorios.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        var imc = intent.extras?.get("imc")
        txtValor.setText("%.1f".format(imc))
        imgEstado.setImageResource(R.drawable.muydelgado)
        imc = "%.1f".format(imc).toFloat()
        if (imc <= 15.9){
            // delgadez severa
            txtMensaje.setText("Delgadez Severa")

        }else if(imc <= 18.4){
            // delgadez
            txtMensaje.setText("Delgadez")
            imgEstado.setImageResource(R.drawable.delgado)
        }else if (imc <= 24.9){
            // saludable
            txtMensaje.setText("Peso Saludable")
            imgEstado.setImageResource(R.drawable.saludable)
        }else if(imc <= 29.9){
            // sobrepeso
            txtMensaje.setText("Sobrepeso")
            imgEstado.setImageResource(R.drawable.gordo)
        }else if (imc >= 30.0){
            // muy sobrepeso
            txtMensaje.setText("Muy Sobrepeso")
            imgEstado.setImageResource(R.drawable.muygordo)
        }

    }
}
