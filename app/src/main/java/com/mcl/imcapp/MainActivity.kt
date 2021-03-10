package com.mcl.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.main_constraint.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_constraint)
        setListeners()
    }

    private fun setListeners() {
        editAltura.doAfterTextChanged { text ->
            Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }
        editPeso.doOnTextChanged { text, _, _, _ ->
            textTitle.text = text
        }
        btnCalcular.setOnClickListener {
            calcularIMC(editPeso.text.toString(), editAltura.text.toString())
        }
    }

    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if (peso != null && altura != null){
            val imc = peso / (altura * altura)
            textTitle.text = "Seu IMC é:\n%.2f".format(imc)
        }
    }
}