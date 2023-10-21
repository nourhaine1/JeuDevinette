package com.example.jeudevinette

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
  lateinit var  debutant: Button
  lateinit var expert:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        debutant=findViewById(R.id.debutant)
        expert =findViewById(R.id.expert)
        debutant.setOnClickListener {
            val i = Intent(this@MainActivity, DebutantMain::class.java)
            startActivity(i)
        }
        expert.setOnClickListener {
            val intent=Intent (this@MainActivity,ExpertActivity::class.java)
            startActivity(intent)

        }

    }
}