package com.bignerdranch.example.proyek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.bignerdranch.example.proyek.activity.InfoCovidActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    private lateinit    var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        supportActionBar?.title = ("Dashboard")
        supportActionBar?.subtitle = ("Kelompok 10")

        auth = FirebaseAuth.getInstance()
        btnLogout.setOnClickListener{
            auth.signOut()
            Intent(this@DashboardActivity, LoginActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }

        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }
    fun btnProfile(item: MenuItem) {
        val intent = Intent(this@DashboardActivity, ProfileActivity::class.java)
        startActivity(intent)
    }
    fun btnChat(item: MenuItem) {
        val intent = Intent(this@DashboardActivity, ViroActivity::class.java)
        startActivity(intent)
    }
    fun info(view: View) {
        val intent = Intent(this@DashboardActivity, InfoCovidActivity::class.java)
        startActivity(intent)
    }
    fun news(view: View){
        val intent = Intent(this@DashboardActivity, NewsActivity::class.java)
        startActivity(intent)
    }
}
