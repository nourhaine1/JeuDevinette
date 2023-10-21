package com.example.jeudevinette

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList

class DebutantMain : AppCompatActivity() {
    lateinit var btn: Button
    lateinit var txt: EditText
    lateinit var mediaPlayer: MediaPlayer
    var targetNbr: Int = 10
    lateinit var inputNumber: Number
    lateinit var history: ArrayList<Int>
    lateinit var guessListView: ListView
    lateinit var guessAdapter: ArrayAdapter<String> // Adapter to display guesses in the ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.debutant_layout)

        txt = findViewById(R.id.nbr)
        btn = findViewById(R.id.btn)
        guessListView = findViewById(R.id.history) // Make sure the ID matches your XML layout
        guessAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1)
        guessListView.adapter = guessAdapter

        history = ArrayList()

        btn.setOnClickListener {
            val inputText = txt.text.toString()
            if (inputText.isNotEmpty()) {
                val inputNumber = inputText.toIntOrNull()
                if (inputNumber != null) {
                    if (targetNbr < inputNumber) {
                        mediaPlayer = MediaPlayer.create(this, R.raw.sup)
                        mediaPlayer.start()
                        Toast.makeText(this, "Le nombre est supérieur de celui que nous avons", Toast.LENGTH_SHORT).show()
                        history.add(inputNumber)
                    } else if (targetNbr > inputNumber) {
                        mediaPlayer = MediaPlayer.create(this, R.raw.inferieur)
                        mediaPlayer.start()
                        Toast.makeText(this, "Le nombre est inférieur de celui que nous avons", Toast.LENGTH_SHORT).show()
                        history.add(inputNumber)
                    } else {
                        val intent = Intent(this@DebutantMain, WinActivity::class.java)
                        startActivity(intent)
                    }

                    // Add the guess to the ListView
                    guessAdapter.add("Vous avez entré: $inputNumber")
                    guessAdapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(this, "Veuillez entrer un nombre valide", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Veuillez entrer un nombre", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
