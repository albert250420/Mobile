package com.bignerdranch.example.proyek

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*


class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val nilai = intent.extras!!.getInt("nilai")
        if (nilai >= 80) {
            txt_comment.text = "Kamu mungkin mengalami gejala Covid, segera periksa kesehatanmu"
        } else if (nilai >= 60) {
            txt_comment.text = "Kamu masih tidak tergolong covid"
        } else {
            txt_comment.text = "Kamu Sehat"
        }
        btn_cobalagi.setOnClickListener{
            val i = Intent(this@ResultActivity, ViroActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}