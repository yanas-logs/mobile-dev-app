package com.example.app_uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSatu = findViewById<Button>(R.id.btnKeBaseSatu)
        val btnDua = findViewById<Button>(R.id.btnKeBaseDua)
        val btnTiga = findViewById<Button>(R.id.btnKeUtsActivity)
        val btnBaseTiga = findViewById<Button>(R.id.btnBaseTiga)

        btnSatu.setOnClickListener {
            startActivity(Intent(this@MainActivity, BaseSatu::class.java))
        }

        btnDua.setOnClickListener {
            startActivity(Intent(this@MainActivity, BaseDua::class.java))
        }

        btnTiga.setOnClickListener {
            startActivity(Intent(this@MainActivity, UtsActivity::class.java))
        }

        btnBaseTiga.setOnClickListener {
            startActivity(Intent(this@MainActivity, BaseTiga::class.java))
        }
    }
}
