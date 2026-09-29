// ImcActivity.kt
package com.example.atividadefaculdade

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoradafaculdadeprojeto.R

class ImcActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        val txtInfoAlunoImc = findViewById<TextView>(R.id.txtInfoAlunoImc)
        val editPeso = findViewById<EditText>(R.id.editPeso)
        val editAltura = findViewById<EditText>(R.id.editAltura)
        val btnCalcularImc = findViewById<Button>(R.id.btnCalcularImc)
        val btnIrInicioImc = findViewById<Button>(R.id.btnIrInicioImc)
        val btnIrMedia = findViewById<Button>(R.id.btnIrMedia)
        val txtResultadoImc = findViewById<TextView>(R.id.txtResultadoImc)

        val nomeAluno = intent.getStringExtra("nomeAluno") ?: ""
        val faculdadeAluno = intent.getStringExtra("faculdadeAluno") ?: ""

        txtInfoAlunoImc.text = "Aluno: $nomeAluno\nFaculdade: $faculdadeAluno"

        btnCalcularImc.setOnClickListener {
            val peso = editPeso.text.toString().trim().toDoubleOrNull()
            val altura = editAltura.text.toString().trim().toDoubleOrNull()

            if (peso != null && altura != null && altura > 0) {
                val imc = peso / (altura * altura)

                val classificacao = when {
                    imc < 18.5 -> "Abaixo do peso"
                    imc < 25 -> "Peso normal"
                    imc < 30 -> "Sobrepeso"
                    else -> "Obesidade"
                }

                txtResultadoImc.text = "IMC: %.2f\nClassificação: %s".format(imc, classificacao)
            } else {
                txtResultadoImc.text = "Digite peso e altura válidos."
            }
        }

        btnIrInicioImc.setOnClickListener {
            startActivity(Intent(this, `MainActivity`::class.java))
        }
    }
}
