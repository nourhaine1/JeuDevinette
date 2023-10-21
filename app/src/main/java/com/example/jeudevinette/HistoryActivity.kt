package com.example.jeudevinette

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history_activity) // Assurez-vous que le layout est correct

        val receivedList = intent.getStringArrayListExtra("historique")

       // val listView = findViewById<ListView>(R.id.listView)
       // val adapter = ArrayAdapter<Int>(this, android.R.layout.simple_list_item_1, receivedList)
       // listView.adapter = adapter
    }
}