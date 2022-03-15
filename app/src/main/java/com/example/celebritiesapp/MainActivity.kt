package com.example.celebritiesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private var celebrityAdapter: CelebrityListAdapter? = null
    private lateinit var celebrityListView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        celebrityListView = findViewById(R.id.celebrityListView)

        celebrityAdapter = CelebrityListAdapter(this@MainActivity)

        celebrityListView.adapter = celebrityAdapter
    }
}