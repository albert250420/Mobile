package com.bignerdranch.example.proyek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    companion object {
        val NAMA: String? = "nama"
        val EMAIL: String? = "email"
        val JENIS_KELAMIN: String? = "jenis kelamin"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar?.title = ("Profile")
        supportActionBar?.subtitle = ("Kelompok 10")
        btnUpdate.setOnClickListener{
            if(etName.text.isEmpty() || etEmail.text.isEmpty() || etJenisKelamin.text.isEmpty()){
                Toast.makeText(
                    this@ProfileActivity,
                    "Data Diri tidak boleh kosong",
                    Toast.LENGTH_SHORT
                ).show()
            }else if(etName.text.isNotEmpty() || etEmail.text.isNotEmpty() || etJenisKelamin.text.isNotEmpty()){
                Toast.makeText(
                    this@ProfileActivity,
                    "Pengisian berhasil dilakukan",
                    Toast.LENGTH_SHORT
                ).show()

                val intent = Intent(this@ProfileActivity, ProfileActivity::class.java)
                val bundle = Bundle()
                bundle.putString(NAMA, etName.text.toString())
                bundle.putString(EMAIL, etEmail.text.toString())
                bundle.putString(JENIS_KELAMIN, etJenisKelamin.text.toString())

                textView3.text=("Nama  : " + bundle.getCharSequence(ProfileActivity.NAMA))
                textView2.text=("Email  : " + bundle.getCharSequence(ProfileActivity.EMAIL))
                textView4.text=("Jenis Kelamin  : " + bundle.getCharSequence(ProfileActivity.JENIS_KELAMIN))

                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
    fun toast(message: String, length:Int = Toast.LENGTH_SHORT){
        Toast.makeText(this, message, length).show()
    }
}