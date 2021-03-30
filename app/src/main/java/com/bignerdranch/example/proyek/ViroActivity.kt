package com.bignerdranch.example.proyek

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_viro.*
import java.util.*


class ViroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viro)
        button_proses.setOnClickListener {
            var nilai = 0 // variabel untuk menampung nilai
            if (radiogroup1!!.toString().toLowerCase(Locale.getDefault()) == "Iya") {
                nilai += 20
            }
            if (radiogroup2!!.toString().toLowerCase(Locale.getDefault()) == "Iya") {
                nilai += 20
            }
            if (radiogroup3!!.toString().toLowerCase(Locale.getDefault()) == "Iya") {
                nilai += 20
            }
            if (radiogroup4!!.toString().toLowerCase(Locale.getDefault()) == "Iya") {
                nilai += 20
            }
            if (radiogroup5!!.toString().toLowerCase(Locale.getDefault()) == "Iya") {
                nilai += 20
            }
            if (radiogroup1!!.toString().toLowerCase(Locale.getDefault()) == "Tidak") {
                nilai += 10
            }
            if (radiogroup2!!.toString().toLowerCase(Locale.getDefault()) == "Tidak") {
                nilai += 10
            }
            if (radiogroup3!!.toString().toLowerCase(Locale.getDefault()) == "Tidak") {
                nilai += 10
            }
            if (radiogroup4!!.toString().toLowerCase(Locale.getDefault()) == "Tidak") {
                nilai += 10
            }
            if (radiogroup5!!.toString().toLowerCase(Locale.getDefault()) == "Tidak") {
                nilai += 10
            }
            val i = Intent(this@ViroActivity, ResultActivity::class.java)
            i.putExtra("nilai", nilai)
            startActivity(i)
            finish()
        }
    }
}