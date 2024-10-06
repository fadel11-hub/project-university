package com.example.mycourseschooloutsidecountry

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity() : AppCompatActivity() {
    private lateinit var rvUniversity: RecyclerView
    private val list = ArrayList<University>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUniversity = findViewById(R.id.rv_univ)
        rvUniversity.setHasFixedSize(true)

//        panggil data xml
        list.addAll(getListUniversity())
        showRecyclerList()
    }

    //    Kode di atas digunakan untuk menampilkan menu pada Activity tertentu. Layout menu diambil dari option_menu.xml yang terdapat di folder menu.
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
//            R.id.action_list -> {
//                rvUniversity.layoutManager = LinearLayoutManager(this)
//            }
//            R.id.action_grid -> {
//                rvUniversity.layoutManager = GridLayoutManager(this, 2)
//            }
            R.id.action_about -> {
                val moveIntent = Intent(this@MainActivity, Akun::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListUniversity(): ArrayList<University> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val listUniversity = ArrayList<University>()
        for (i in dataName.indices) {
            val university = University(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listUniversity.add(university)
        }

        return listUniversity
    }

    private fun showRecyclerList() {
        rvUniversity.layoutManager = LinearLayoutManager(this)
        val listUniversity = ListUniversity(list)
        rvUniversity.adapter = listUniversity

        listUniversity.setOnItemClickCallback(object : ListUniversity.OnItemClickCallback {
            override fun onItemClicked(data: University) {
                showSelectedUniv(data)
            }

        })
    }

    private fun showSelectedUniv(univ: University ) {
        Toast.makeText(this, "Kamu memlih " + univ.name, Toast.LENGTH_SHORT).show()
    }
}
