package com.example.uas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class UasActivity : AppCompatActivity() {
    var totalBelanja = 0
    var jumlahItem = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uas)

        val etNama = findViewById<EditText>(R.id.etNama)
        val etHarga = findViewById<EditText>(R.id.etHarga)
        val etJumlah = findViewById<EditText>(R.id.etJumlah)
        val btnTambah = findViewById<Button>(R.id.btnTambah)
        val btnProses = findViewById<Button>(R.id.btnProses)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)
        val btnKembali = findViewById<Button>(R.id.btnKembali)

        btnTambah.setOnClickListener {

            if (etNama.text.isEmpty() || etHarga.text.isEmpty() || etJumlah.text.isEmpty()) {
                Toast.makeText(this, "Semua input harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val harga = etHarga.text.toString().toInt()
            jumlahItem = etJumlah.text.toString().toInt()

            totalBelanja = hitungSubtotal(harga)

            etNama.text.clear()
            etHarga.text.clear()
            etJumlah.text.clear()
            etNama.requestFocus()
        }

        btnProses.setOnClickListener {

                if (totalBelanja == 0 || jumlahItem == 0) {
                Toast.makeText(this, "Data belum ditambahkan", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val subtotal = totalBelanja

            val diskon = when {
                subtotal > 500_000 -> subtotal * 10 / 100
                subtotal > 300_000 -> subtotal * 5 / 100
                else -> 0
            }

            val totalBayar = subtotal - diskon

            tvHasil.text = """
                Total Belanja : Rp $subtotal
                Diskon        : Rp $diskon
                Total Bayar   : Rp $totalBayar 
            """.trimIndent()
        }
        btnKembali.setOnClickListener {
            finish()
        }
    }

    fun hitungSubtotal(harga: Int): Int {
        var subtotal = 0
        for (i in 1..jumlahItem) {
            subtotal += harga
        }
        return subtotal
    }
}
