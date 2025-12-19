package com.example.app_uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.Calendar

class BaseTiga : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_tiga)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)
        val btnKembali2 = findViewById<Button>(R.id.btnKembali2)
        val btnLoop = findViewById<Button>(R.id.btnLoop)
        val edtNilaiAwal: EditText = findViewById(R.id.edtNilaiAwal)
        val edtNilaiAkhir: EditText = findViewById(R.id.edtNilaiAkhir)

        btnLoop.setOnClickListener {
            val NilaiAwal = edtNilaiAwal.text.toString().toInt()
            val NilaiAkhir = edtNilaiAkhir.text.toString().toInt()

            if (NilaiAwal == null || NilaiAkhir == null) {
                tvHasil.text = "Input tidak boleh kosong!"
                return@setOnClickListener
            } else {
                var i = NilaiAwal
                var result = "\n"

                do {
                    result += "$i "
                    i++
                } while (i <= NilaiAkhir)
                tvHasil.text = result            }
        }

        btnKembali2.setOnClickListener {
            startActivity(Intent(this@BaseTiga, MainActivity::class.java))
        }
    }
}
