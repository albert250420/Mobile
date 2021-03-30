package com.bignerdranch.example.proyek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = ("G.jala")
        supportActionBar?.subtitle = ("Kelompok 10")
    }
        fun Pindah(view: View?) {
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
    }
}