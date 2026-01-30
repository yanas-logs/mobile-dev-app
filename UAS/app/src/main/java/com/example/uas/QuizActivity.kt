package com.example.uas

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class QuizActivity : AppCompatActivity() {
    var namaBarangGlobal = ""
    var totalStokGlobal = 0
    var barangKeluarGlobal = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val etNamaBarang = findViewById<EditText>(R.id.etNamaBarang)
        val etTotalStok = findViewById<EditText>(R.id.etTotalStok)
        val etBarangKeluar = findViewById<EditText>(R.id.etBarangKeluar)
        val btnTambah = findViewById<Button>(R.id.btnTambah)
        val btnProses = findViewById<Button>(R.id.btnProses)
        val btnKembali = findViewById<Button>(R.id.btnKembali)
        val tvHasil = findViewById<TextView>(R.id.tvHasilQuiz)

        btnTambah.setOnClickListener {

            if (etNamaBarang.text.isEmpty() ||
                etTotalStok.text.isEmpty() ||
                etBarangKeluar.text.isEmpty()
            ) {
                Toast.makeText(this, "Semua input harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            namaBarangGlobal = etNamaBarang.text.toString()
            totalStokGlobal = etTotalStok.text.toString().toInt()
            barangKeluarGlobal = etBarangKeluar.text.toString().toInt()

            etNamaBarang.text.clear()
            etTotalStok.text.clear()
            etBarangKeluar.text.clear()
            etNamaBarang.requestFocus()
        }

        btnProses.setOnClickListener {

            if (namaBarangGlobal.isEmpty()) {
                Toast.makeText(this, "Data belum ditambahkan", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val sisaStok = hitungSisaStok()

            tvHasil.text = """
                Nama Barang        : $namaBarangGlobal
                Total Barang Keluar: $barangKeluarGlobal
                Sisa Stok Barang   : $sisaStok
            """.trimIndent()
        }

        btnKembali.setOnClickListener {
            finish()
        }
    }

    fun hitungSisaStok(): Int {
        return if (barangKeluarGlobal <= totalStokGlobal) {
            totalStokGlobal - barangKeluarGlobal
        } else {
            0
        }
    }
}
