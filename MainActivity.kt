// MainActivity.kt
package com.example.atividadefaculdade

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editNomeAluno = findViewById<EditText>(R.id.editNomeAluno)
        val editFaculdade = findViewById<EditText>(R.id.editFaculdade)
        val btnMedia = findViewById<Button>(R.id.btnMedia)
        val btnImc = findViewById<Button>(R.id.btnImc)

        btnMedia.setOnClickListener {
            val nome = editNomeAluno.text.toString().trim()
            val faculdade = editFaculdade.text.toString().trim()

            if (nome.isEmpty()) {
                editNomeAluno.error = "Digite o nome do aluno"
                editNomeAluno.requestFocus()
            } else if (faculdade.isEmpty()) {
                editFaculdade.error = "Digite a faculdade"
                editFaculdade.requestFocus()
            } else {
                val mediaActivity = null
                val intent = Intent(this,mediaActivity::class)
                intent.putExtra("nomeAluno", nome)
                intent.putExtra("faculdadeAluno", faculdade)
                startActivity(intent)
            }
        }

        btnImc.setOnClickListener {
            val nome = editNomeAluno.text.toString().trim()
            val faculdade = editFaculdade.text.toString().trim()

            if (nome.isEmpty()) {
                editNomeAluno.error = "Digite o nome do aluno"
                editNomeAluno.requestFocus()
            } else if (faculdade.isEmpty()) {
                editFaculdade.error = "Digite a faculdade"
                editFaculdade.requestFocus()
            } else {
                val intent = Intent(this, ImcActivity::class.java)
                intent.putExtra("nomeAluno", nome)
                intent.putExtra("faculdadeAluno", faculdade)
                startActivity(intent)
            }
        }
    }
}
