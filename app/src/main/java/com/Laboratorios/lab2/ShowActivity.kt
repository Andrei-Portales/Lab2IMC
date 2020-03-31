package com.Laboratorios.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        var imc = intent.extras?.get("imc")
        txtValor.setText("%.1f".format(imc))

        imc = "%.1f".format(imc).toFloat()
        if (imc <= 15.9){
            // delgadez severa
            txtMensaje.setText("Delgadez Severa")
        }else if(imc >= 16.0 && imc <= 18.4){
            // delgadez
            txtMensaje.setText("Delgadez")
        }else if (imc >= 18.5 && imc <= 24.9){
            // saludable
            txtMensaje.setText("Peso Saludable")
        }else if(imc <= 25.0 && imc >= 29.9){
            // sobrepeso
            txtMensaje.setText("Sobrepeso")
        }else if (imc >= 30.0){
            // muy sobrepeso
            txtMensaje.setText("Muy Sobrepeso")
        }

    }
}
