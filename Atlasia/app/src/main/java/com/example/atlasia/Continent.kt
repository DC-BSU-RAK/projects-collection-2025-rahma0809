package com.example.atlasia

import android.content.Intent
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

class Continent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_continent)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val goSelectButton :Button = findViewById(R.id.asiaButton)
        goSelectButton.setOnClickListener{
            val intent = Intent(this,Asia::class.java)
            startActivity(intent)
        }
        val goButton :Button = findViewById(R.id.europeButton)
        goButton.setOnClickListener{
            val intent = Intent(this,Europe::class.java)
            startActivity(intent)
        }
        val gotoButton :Button = findViewById(R.id.africaButton)
        gotoButton.setOnClickListener{
            val intent = Intent(this,Africa::class.java)
            startActivity(intent)
        }
        val goToSubSelectButton :ImageButton = findViewById(R.id.backButton)
        goToSubSelectButton.setOnClickListener{
            val intent = Intent(this,TripScreen::class.java)
            startActivity(intent)
        }
        val instButton: ImageButton = findViewById(R.id.instButton3)
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
    }
}