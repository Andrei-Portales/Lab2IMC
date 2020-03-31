package com.Laboratorios.lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startBotones()
    }

    /**
     * Funcion en donde se les asigna acciones a los botones
     */
    fun startBotones() {
        // boton procesar
        btnProcesar.setOnClickListener {
            if (txtEstatura.text.toString().isNotEmpty() && txtPeso.text.toString().isNotEmpty()){
                if (comprobarIntervalo(txtEstatura.text.toString().toFloat()) && comprobarIntervalo(txtPeso.text.toString().toFloat())){
                    var intent = Intent(this, ShowActivity::class.java)
                    var estatura = convertirEstatura(txtEstatura.text.toString().toFloat())
                    var peso = convertPeso(txtPeso.text.toString().toFloat())
                    intent.putExtra("imc",getIMC(estatura,peso))
                    startActivity(intent)
                    txtEstatura.setText(null)
                    txtPeso.setText(null)
                }else{
                    Toast.makeText(this, "Ingrese un valor entre 1 y 270", Toast.LENGTH_LONG).show()
                    txtEstatura.setText(null)
                    txtPeso.setText(null)
                }
            }else{
                Toast.makeText(this, "Tienes campos vacios", Toast.LENGTH_LONG).show()
            }
        }

        btnProcesar.setOnLongClickListener{
            Toast.makeText(this, "IMC = Peso (kg) / altura (m)2", Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }
    }

    /**
     * Funcion para comprobar si los numeros ingresado estan en el intervalo
     */
    fun comprobarIntervalo(valor: Float): Boolean{
        var r : Boolean = false
        if (valor > 0 && valor <= 270){
            r = true
        }
        return r
    }

    /**
     * Funcion para convertir el peso de libras a kilogramos
     */
    fun convertPeso(peso: Float): Float{
        return (peso / 2.205).toFloat()
    }

    /**
     * Funcion para convertir centimetros a metros
     */
    fun convertirEstatura(estatura: Float): Float {
        return estatura / 100
    }

    /**
     * Funcion para obtener el IMC
     */
    fun getIMC(estatura: Float, peso: Float): Float{
        return (peso/Math.pow(estatura.toDouble(),2.0)).toFloat()
    }




}
