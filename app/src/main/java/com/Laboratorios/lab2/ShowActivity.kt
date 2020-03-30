package com.Laboratorios.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ShowActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        var imc = intent.extras?.get("imc")
        Toast.makeText(this, imc.toString(), Toast.LENGTH_LONG).show()
    }
}
