package com.example.jeudevinette

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class WinActivity: AppCompatActivity() {

    lateinit var mediaPlayer:MediaPlayer
    lateinit var backbtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.win_activity)
        backbtn=findViewById(R.id.backbtn)

        val gifImageView = findViewById<ImageView>(R.id.bravo)
        Glide.with(this)
            .asGif()
            .load(R.raw.minion)  // Replace with your actual GIF resource
            .into(gifImageView)
        mediaPlayer= MediaPlayer.create(this,R.raw.applaudissement)
        mediaPlayer.start()
        backbtn.setOnClickListener {
            val intent = Intent(this@WinActivity, MainActivity::class.java)
            startActivity(intent)
        }


    }

}
