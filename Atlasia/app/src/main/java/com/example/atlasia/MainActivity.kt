package com.example.atlasia

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupWindow
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val instButton: ImageButton = findViewById(R.id.instButton)
        instButton.setOnClickListener {
            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.activity_inst_popup, null)
            val width = 1050
            val height = 1850
            val instructWindow = PopupWindow(popupView, width, height, true)
            instructWindow.showAtLocation(popupView, Gravity.BOTTOM, 2, 100)

            val closeButton: Button = popupView.findViewById(R.id.closeButton)
            closeButton.setOnClickListener {
                instructWindow.dismiss()
            }
        }
        val goToSubSelectButton : Button = findViewById(R.id.beginButton)
        goToSubSelectButton.setOnClickListener{
            val intent = Intent(this,TripScreen::class.java)
            startActivity(intent)
        }
        //  Start background music
        mediaPlayer = MediaPlayer.create(this, R.raw.bgmusic)
        mediaPlayer.isLooping = true
        mediaPlayer.start()

    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release() //  Stop music when app is closed
    }
}