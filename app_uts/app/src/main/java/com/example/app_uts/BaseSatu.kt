package com.example.app_uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Calendar

class BaseSatu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_satu)


        val nama = "YANA SURYANA"

        val tahunLahir = 1999
        val calendar = Calendar.getInstance()
        val tahunSekarang = calendar.get(Calendar.YEAR)
        val usiaTahunDepan = (tahunSekarang + 1) - tahunLahir
        val btnKembali = findViewById<Button>(R.id.btnKembali2)

        val tvInfo = findViewById<TextView>(R.id.tvInfo)
        tvInfo.text = "Hai $nama \nTahun depan anda $usiaTahunDepan Tahun"

        btnKembali.setOnClickListener {
            startActivity(Intent(this@BaseSatu, MainActivity::class.java))
        }
    }
}
