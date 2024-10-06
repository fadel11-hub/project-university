package com.example.mycourseschooloutsidecountry

import android.app.Person
import android.content.Intent
import android.media.Image
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailUniversity : AppCompatActivity() {
    companion object {
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
//          const val EXTRA_DATA = "DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_university)

//        val tvDataImage: ImageView = findViewById(R.id.tv_object_received_image)
//        val tvDataName: TextView = findViewById(R.id.tv_object_received_title)
//        val tvDataDescription: TextView = findViewById(R.id.tv_object_received_description)

        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)
        val name = intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)

        val photoUniversity = findViewById<ImageView>(R.id.tv_object_received_image)
        val nameUniversity = findViewById<TextView>(R.id.tv_object_received_title)
        val descriptionUniversity = findViewById<TextView>(R.id.tv_object_received_description)

        photoUniversity.setImageResource(photo)
        nameUniversity.text = name
        descriptionUniversity.text = description

//        Log.d("Detail Data", photo.toString())
//        Log.d("Detail Data", name.toString())
//        Log.d("Detail Data", description.toString())

//        val person = if (Build.VERSION.SDK_INT >= 33) {
//            intent.getParcelableExtra<Person>(EXTRA_DATA, Person::class.java)
//        } else {
//            @Suppress("DEPRECATION")
//            intent.getParcelableExtra<Person>(EXTRA_DATA)
//        }
//        if (person != null) {
//            Log.d("Detail Data", EXTRA_DATA.toString())
////            tvObject.text = text
//        }
//        val data = intent.getParcelableExtra<University>("DATA")
//        Log.d("Detail Data", data.toString())
    }
}