package com.example.uas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnQuiz = findViewById<Button>(R.id.btnQuiz)
        val btnUas = findViewById<Button>(R.id.btnUas)
        val btnB1 = findViewById<Button>(R.id.btnbasesatu)

        btnQuiz.setOnClickListener {
            val intentQuiz = Intent(this, QuizActivity::class.java)
            startActivity(intentQuiz)
        }

        btnUas.setOnClickListener {
            val intentUas = Intent(this, UasActivity::class.java)
            startActivity(intentUas)
        }
        btnB1.setOnClickListener {
            val intentUas = Intent(this, BaseSatu::class.java)
            startActivity(intentUas)
        }
    }
}
