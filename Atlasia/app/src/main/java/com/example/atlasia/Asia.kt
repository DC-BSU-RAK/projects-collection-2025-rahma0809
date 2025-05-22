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

class Asia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_asia)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val indButton :Button = findViewById(R.id.iexploreButton)
        indButton.setOnClickListener{
            val intent = Intent(this,India::class.java)
            startActivity(intent)
        }
        val thaButton :Button = findViewById(R.id.texploreButton)
        thaButton.setOnClickListener{
            val intent = Intent(this,Thailand::class.java)
            startActivity(intent)
        }
        val uaButton :Button = findViewById(R.id.uexploreButton)
        uaButton.setOnClickListener{
            val intent = Intent(this,Uae::class.java)
            startActivity(intent)
        }
        val goToSubSelectButton :ImageButton = findViewById(R.id.backButton2)
        goToSubSelectButton.setOnClickListener{
            val intent = Intent(this,TripScreen::class.java)
            startActivity(intent)
        }
        val goSelectButton :ImageButton = findViewById(R.id.contButton)
        goSelectButton.setOnClickListener{
            val intent = Intent(this,Continent::class.java)
            startActivity(intent)
        }
        val goButton :ImageButton = findViewById(R.id.calButton4)
        goButton.setOnClickListener{
            val intent = Intent(this,Calender::class.java)
            startActivity(intent)
        }
        val gotoButton :ImageButton = findViewById(R.id.listButton4)
        gotoButton.setOnClickListener{
            val intent = Intent(this,WishList::class.java)
            startActivity(intent)
        }
        val instButton: ImageButton = findViewById(R.id.instButton4)
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