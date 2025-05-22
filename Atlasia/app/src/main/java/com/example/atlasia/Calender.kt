package com.example.atlasia

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.CalendarView
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class Calender : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calender)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val goToSubSelectButton : ImageButton = findViewById(R.id.backButton6)
        goToSubSelectButton.setOnClickListener{
            val intent = Intent(this,TripScreen::class.java)
            startActivity(intent)
        }
        val goSelectButton : ImageButton = findViewById(R.id.contButton5)
        goSelectButton.setOnClickListener{
            val intent = Intent(this,Continent::class.java)
            startActivity(intent)
        }
        val goButton : ImageButton = findViewById(R.id.listButton)
        goButton.setOnClickListener{
            val intent = Intent(this,WishList::class.java)
            startActivity(intent)
        }
        val calendarView = findViewById<CalendarView>(R.id.calendarView)

// Set current date as default
        calendarView.date = System.currentTimeMillis()

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)

            val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
            val selectedDate = dateFormat.format(calendar.time)

            Toast.makeText(this, "Next trip saved: $selectedDate", Toast.LENGTH_SHORT).show()

            // Save to SharedPreferences
            val prefs = getSharedPreferences("AtlassiaPrefs", MODE_PRIVATE)
            prefs.edit().putString("next_trip_date", selectedDate).apply()
        }

    }
}