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

class Europe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_europe)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val goSubButton : Button = findViewById(R.id.spexploreButton)
        goSubButton.setOnClickListener{
            val intent = Intent(this,Spain::class.java)
            startActivity(intent)
        }
        val subButton : Button = findViewById(R.id.fexploreButton)
        subButton.setOnClickListener{
            val intent = Intent(this,France::class.java)
            startActivity(intent)
        }
        val itaButton : Button = findViewById(R.id.itexploreButton)
        itaButton.setOnClickListener{
            val intent = Intent(this,Italy::class.java)
            startActivity(intent)
        }
        val goToSubSelectButton : ImageButton = findViewById(R.id.backButton3)
        goToSubSelectButton.setOnClickListener{
            val intent = Intent(this,TripScreen::class.java)
            startActivity(intent)
        }
        val goSelectButton : ImageButton = findViewById(R.id.contButton2)
        goSelectButton.setOnClickListener{
            val intent = Intent(this,Continent::class.java)
            startActivity(intent)
        }
        val goToSubButton : ImageButton = findViewById(R.id.calButton2)
        goToSubButton.setOnClickListener{
            val intent = Intent(this,Calender::class.java)
            startActivity(intent)
        }
        val goToButton : ImageButton = findViewById(R.id.listButton2)
        goToButton.setOnClickListener{
            val intent = Intent(this,WishList::class.java)
            startActivity(intent)
        }
        val instButton: ImageButton = findViewById(R.id.instButton5)
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