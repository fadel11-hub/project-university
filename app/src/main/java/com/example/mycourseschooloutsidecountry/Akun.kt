package com.example.mycourseschooloutsidecountry

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Akun : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_akun)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        val about = findViewById<ImageView>(R.id.back_icon)

        about.setOnClickListener {
            val moveBackAbout = Intent(this@Akun, MainActivity::class.java)
            startActivity(moveBackAbout)

        }

    }
}