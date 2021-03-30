package com.bignerdranch.example.proyek.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bignerdranch.example.proyek.R
import com.bignerdranch.example.proyek.api.RetrofitClient
import com.bignerdranch.example.proyek.model.IndonesiaResponse
import kotlinx.android.synthetic.main.activity_info_covid.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InfoCovidActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_covid)
        showIndonesia()

        btnProvince.setOnClickListener{
            Intent(this@InfoCovidActivity, ProvinceActivity::class.java).also {
                startActivity(it)
            }
        }
    }
    private fun showIndonesia(){
        RetrofitClient.instance.getIndonesia().enqueue(object : Callback<ArrayList<IndonesiaResponse>>{
            override fun onResponse(
                call: Call<ArrayList<IndonesiaResponse>>,
                response: Response<ArrayList<IndonesiaResponse>>
            ) {
                val indonesia = response.body()?.get(0)
                val positive = indonesia?.positif
                val hospitalized = indonesia?.dirawat
                val recover = indonesia?.sembuh
                val death = indonesia?.meninggal

                tvPositive.text = positive
                tvHospitalized.text = hospitalized
                tvRecover.text = recover
                tvDeath.text = death
            }

            override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                Toast.makeText(this@InfoCovidActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}