package com.example.app_uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class UtsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uts)

        val edtBerat: EditText = findViewById(R.id.edtBerat)
        val edtTinggi: EditText = findViewById(R.id.edtTinggi)
        val btnHitung: Button = findViewById(R.id.btnHitung)
        val txtHasil: TextView = findViewById(R.id.txtHasil)
        val btnKembali: Button = findViewById(R.id.btnKembali2)

        // tombol kembali
        btnKembali.setOnClickListener {
            finish()
        }

        // tombol hitung BMI
        btnHitung.setOnClickListener {

            // ambil input
            val berat = edtBerat.text.toString().toFloatOrNull()
            val tinggi = edtTinggi.text.toString().toFloatOrNull()

            // validasi
            if (berat == null || tinggi == null) {
                txtHasil.text = "Input tidak boleh kosong!"
                return@setOnClickListener
            }

            // konversi tinggi (cm → meter)
            val tinggiMeter = tinggi / 100

            // hitung BMI
            val bmi = berat / (tinggiMeter * tinggiMeter)

            // tentukan kategori
            val kategori = when {
                bmi < 18.5 -> "Underweight"
                bmi < 25 -> "Normal"
                bmi < 30 -> "Overweight"
                else -> "Obesitas"
            }

            // tampilkan hasil
            txtHasil.text = """
                BMI Anda : %.2f
                Kategori : %s
            """.trimIndent().format(bmi, kategori)
        }
    }
}
