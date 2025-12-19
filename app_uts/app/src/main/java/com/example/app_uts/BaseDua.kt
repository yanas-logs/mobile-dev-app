package com.example.app_uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class BaseDua : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_dua)

        val etInput = findViewById<EditText>(R.id.etInput)
        val btnIfElse = findViewById<Button>(R.id.btnIfElse)
        val btnWhen = findViewById<Button>(R.id.btnWhen)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        btnIfElse.setOnClickListener {
            val input = etInput.text.toString()
            if (input.isNotEmpty()) {
                val angka = input.toInt()
                val hasil = if (angka % 2 == 0) "Angka $angka adalah Genap" else "Angka $angka adalah Ganjil"
                tvHasil.text = hasil
            } else {
                tvHasil.text = "Masukkan angka terlebih dahulu"
            }
        }

        btnWhen.setOnClickListener {
            val input = etInput.text.toString()
            if (input.isNotEmpty()) {
                val hari = when(input.toInt()) {
                    1 -> "Senin"
                    2 -> "Selasa"
                    3 -> "Rabu"
                    4 -> "Kamis"
                    5 -> "Jumat"
                    6 -> "Sabtu"
                    7 -> "Minggu"
                    else -> "Hari tidak valid"
                }
                tvHasil.text = "Hari ke-${input.toInt()} adalah $hari"
            } else {
                tvHasil.text = "Masukkan angka 1-7 terlebih dahulu"
            }
        }
        val btnKembali3 = findViewById<Button>(R.id.btnKembali3)
        btnKembali3.setOnClickListener {
            startActivity(Intent(this@BaseDua, MainActivity::class.java))
        }
    }
}

