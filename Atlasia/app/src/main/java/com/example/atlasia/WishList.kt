package com.example.atlasia

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WishList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_wish_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val goToSubSelectButton : ImageButton = findViewById(R.id.backButton5)
        goToSubSelectButton.setOnClickListener{
            val intent = Intent(this,TripScreen::class.java)
            startActivity(intent)
        }
        val goSelectButton : ImageButton = findViewById(R.id.contButton4)
        goSelectButton.setOnClickListener{
            val intent = Intent(this,Continent::class.java)
            startActivity(intent)
        }
        val goButton : ImageButton = findViewById(R.id.calButton)
        goButton.setOnClickListener{
            val intent = Intent(this,Calender::class.java)
            startActivity(intent)
        }

        val prefs = getSharedPreferences("AtlasiaPrefs", MODE_PRIVATE)
        val wishlist = prefs.getStringSet("wishlist", setOf()) ?: setOf()

        val wishlistText = findViewById<TextView>(R.id.wishView)

        wishlistText.text = if (wishlist.isNotEmpty()) {
            "Your Wishlist:\n\n" + wishlist.joinToString("\n")
        } else {
            "Your wishlist is empty."
        }
    }
}