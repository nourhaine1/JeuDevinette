package com.example.jeudevinette

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ExpertActivity: AppCompatActivity() {
    lateinit var btn: Button
    lateinit var txt: EditText
    lateinit var mediaPlayer: MediaPlayer
    var targetNbr: Int = 10
    lateinit var inputNumber: Number

     lateinit var countDownTimer: CountDownTimer
    private lateinit var time: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.expert_layout)
        time = findViewById(R.id.time)
        btn=findViewById(R.id.btnex)
        txt=findViewById(R.id.nbrex)
        countDownTimer = object : CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                time.text = "Time Remaining: $secondsRemaining seconds"
            }

            override fun onFinish() {
                mediaPlayer= MediaPlayer.create(this@ExpertActivity,R.raw.up)
                mediaPlayer.start()
                val alertDialog = AlertDialog.Builder(this@ExpertActivity)
                alertDialog.setTitle("Tempse écoulé !")
                alertDialog.setMessage("Retour à la page dacceuil.")
                alertDialog.setPositiveButton("OK") { _, _ ->
                    // Navigate back to the home page
                    val intent = Intent(this@ExpertActivity, MainActivity::class.java)
                    startActivity(intent)
                }
                alertDialog.setCancelable(false)
                alertDialog.show()
            }
        }
        countDownTimer.start()

        btn.setOnClickListener {
            // Check if the user entered a number during each tick
            val inputText = txt.text.toString()
            if (inputText.isNotEmpty()) {
                val inputNumber = inputText.toIntOrNull()
                if (inputNumber != null) {
                    // Compare inputNumber with targetNbr
                    if (targetNbr < inputNumber) {
                        mediaPlayer = MediaPlayer.create(this@ExpertActivity, R.raw.sup)
                        mediaPlayer.start()
                        Toast.makeText(this@ExpertActivity, "Le nombre est supérieur à celui que nous avons", Toast.LENGTH_SHORT).show()
                    } else if (targetNbr > inputNumber) {
                        mediaPlayer = MediaPlayer.create(this@ExpertActivity, R.raw.inferieur)
                        mediaPlayer.start()
                        Toast.makeText(this@ExpertActivity, "Le nombre est inférieur à celui que nous avons", Toast.LENGTH_SHORT).show()
                    } else {
                        // Redirect to the "bravooo" page
                        val intent = Intent(this@ExpertActivity, WinActivity::class.java)
                        startActivity(intent)
                    }
                } else {
                    // Conversion failed, the input was not a valid number
                    Toast.makeText(this@ExpertActivity, "Veuillez entrer un nombre valide", Toast.LENGTH_SHORT).show()
                }
            }
        }


            }
        }



