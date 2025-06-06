package com.example.atlasia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Thailand : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_thailand)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val goToButton : Button = findViewById(R.id.calentButton)
        goToButton.setOnClickListener{
            val intent = Intent(this,Calender::class.java)
            startActivity(intent)
        }
        val goToSubButton : ImageButton = findViewById(R.id.prevButton)
        goToSubButton.setOnClickListener{
            val intent = Intent(this,Asia::class.java)
            startActivity(intent)
        }
        val addToWishlistButton = findViewById<Button>(R.id.thaiwButton)

        addToWishlistButton.setOnClickListener {
            val prefs = getSharedPreferences("AtlasiaPrefs", MODE_PRIVATE)
            val editor = prefs.edit()

            val currentWishlist = prefs.getStringSet("wishlist", mutableSetOf())?.toMutableSet() ?: mutableSetOf()
            currentWishlist.add("Thailand")

            editor.putStringSet("wishlist", currentWishlist)
            editor.apply()

            Toast.makeText(this, "Added to wishlist!", Toast.LENGTH_SHORT).show()
        }
    }
}