package com.example.atlasia

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupWindow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TripScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_trip_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tripDateText = findViewById<TextView>(R.id.tripDateDisplay)

        val prefs = getSharedPreferences("AtlassiaPrefs", MODE_PRIVATE)
        val savedDate = prefs.getString("next_trip_date", null)

        if (savedDate != null) {
            tripDateText.text = "Next trip is on: $savedDate"
        } else {
            tripDateText.text = "Set your trip date"
        }
        val instButton: ImageButton = findViewById(R.id.instButton2)
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

        val goToSubSelectButton : ImageButton = findViewById(R.id.globeButton)
        goToSubSelectButton.setOnClickListener{
            val intent = Intent(this,Continent::class.java)
            startActivity(intent)
        }
        val goToSubButton : ImageButton = findViewById(R.id.wishButton)
        goToSubButton.setOnClickListener{
            val intent = Intent(this,WishList::class.java)
            startActivity(intent)
        }
        val goToButton : ImageButton = findViewById(R.id.calenderButton)
        goToButton.setOnClickListener{
            val intent = Intent(this,Calender::class.java)
            startActivity(intent)
        }
    }
}