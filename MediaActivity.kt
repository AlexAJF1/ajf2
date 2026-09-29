// MediaActivity.kt
package com.example.calculadoradafaculdadeprojeto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MediaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media)

        val txtInfoAluno = findViewById<TextView>(R.id.txtInfoAluno)
        val editNota1 = findViewById<EditText>(R.id.editNota1)
        val editNota2 = findViewById<EditText>(R.id.editNota2)
        val editNota3 = findViewById<EditText>(R.id.editNota3)
        val editNota4 = findViewById<EditText>(R.id.editNota4)
        val btnCalcularMedia = findViewById<Button>(R.id.btnCalcularMedia)
        val btnIrInicioMedia = findViewById<Button>(R.id.btnIrInicioMedia)
        val btnIrImc = findViewById<Button>(R.id.btnIrImc)
        val txtResultadoMedia = findViewById<TextView>(R.id.txtResultadoMedia)

        val nomeAluno = intent.getStringExtra("nomeAluno") ?: ""
        val faculdadeAluno = intent.getStringExtra("faculdadeAluno") ?: ""

        txtInfoAluno.text = "Aluno: $nomeAluno\nFaculdade: $faculdadeAluno"

        btnCalcularMedia.setOnClickListener {
            val n1 = editNota1.text.toString().trim().toDoubleOrNull()
            val n2 = editNota2.text.toString().trim().toDoubleOrNull()
            val n3 = editNota3.text.toString().trim().toDoubleOrNull()
            val n4 = editNota4.text.toString().trim().toDoubleOrNull()

            if (n1 == null || n2 == null || n3 == null || n4 == null) {
                txtResultadoMedia.text = "Nota inválida"
                Toast.makeText(this, "Nota inválida", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val media = (n1 + n2 + n3 + n4) / 4
            val situacao = if (media >= 7) "Aprovado" else "Reprovado"

            txtResultadoMedia.text = "Média: %.2f\nSituação: %s".format(media, situacao)
        }

        btnIrInicioMedia.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        btnIrImc.setOnClickListener {
            val intent = Intent(this, ImcActivity::class.java)
            intent.putExtra("nomeAluno", nomeAluno)
            intent.putExtra("faculdadeAluno", faculdadeAluno)
            startActivity(intent)
        }
    }
}

        }
    }

    private fun validarNota(texto: String, campo: EditText): Double? {
        if (texto.isEmpty()) {
            campo.error = "Digite uma nota"
            campo.requestFocus()
            return null
        }

        val nota = texto.toDoubleOrNull()
        if (nota == null) {
            campo.error = "Nota inválida"
            campo.requestFocus()
            return null
        }

        return nota
    }
}