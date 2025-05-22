package com.example.novelnudge

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
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
            val popupView = inflater.inflate(R.layout.activity_pop_up_inst, null)
            val width = 1050
            val height = 1850
            val instructWindow = PopupWindow(popupView, width, height, true)
            instructWindow.showAtLocation(popupView, Gravity.BOTTOM, 2, 100)

            val closeButton:Button = popupView.findViewById(R.id.closeButton)
            closeButton.setOnClickListener {
                instructWindow.dismiss()
            }
            val genreSpinner: Spinner = findViewById(R.id.genreSpinner)
            val bookSpinner: Spinner = findViewById(R.id.bookSpinner)
            val runButton: Button = findViewById(R.id.runButton)
            val cityButton: ImageButton = findViewById(R.id.cityButton)
            val castleButton: ImageButton = findViewById(R.id.castleButton)

            val genres =
                arrayOf("Adventure", "Horror", "Poetry", "Detective Fiction")
            val books = arrayOf(
                "Strong Characters",
                "Twists and Surprises",
                "Unexpected Endings",
                "Emotional Depth"
            )

            genreSpinner.adapter = ArrayAdapter(
                this@MainActivity,
                android.R.layout.simple_spinner_dropdown_item,
                genres
            )
            bookSpinner.adapter = ArrayAdapter(
                this@MainActivity,
                android.R.layout.simple_spinner_dropdown_item,
                books
            )

// Variables to track user choice
            var userChoice = ""

// Handle which button was pressed
            cityButton.setOnClickListener {
                userChoice = "city"
            }
            castleButton.setOnClickListener {
                userChoice = "castle"
            }

// Map: [Genre][Book Depth][City/Castle] → Pair of Image Resource + Book Name
            val bookMap = mapOf(
                Triple(
                    "Adventure",
                    "Strong Characters",
                    "castle"
                ) to Pair(R.drawable.bookone, "The Death Of Vivek OJI"),
                Triple(
                    "Horror",
                    "Strong Characters",
                    "city"
                ) to Pair(R.drawable.booktwo, "Don't Look Back"),
                Triple(
                    "Poetry",
                    "Strong Characters",
                    "castle"
                ) to Pair(R.drawable.bookthree, "Hide And Seek"),
                Triple(
                    "Detective Fiction",
                    "Strong Characters",
                    "city"
                ) to Pair(R.drawable.bookfour, "Dark World"),
                Triple(
                    "Horror",
                    "Twists and Surprises",
                    "city"
                ) to Pair(R.drawable.bookfive, "Eye of The Witch"),
                Triple(
                    "Adventure",
                    "Twists and Surprises",
                    "city"
                ) to Pair(R.drawable.booksix, "Heir To The Gift"),
                Triple(
                    "Poetry",
                    "Twists and Surprises",
                    "castle"
                ) to Pair(R.drawable.bookseven, "What We Set in Motion"),
                Triple(
                    "Detective Fiction",
                    "Twists and Surprises",
                    "city"
                ) to Pair(R.drawable.bookeight, "The Spiritual Hunter"),
                Triple(
                    "Detective Fiction",
                    "Unexpected Endings",
                    "city"
                ) to Pair(R.drawable.booknine, "The Dawnlands Catch"),
                Triple(
                    "Horror",
                    "Unexpected Endings",
                    "city"
                ) to Pair(R.drawable.booktenten, "Spiral"),
                Triple(
                    "Adventure",
                    "Unexpected Endings",
                    "city"
                ) to Pair(R.drawable.bookeleven, "Starling"),
                Triple(
                    "Poetry",
                    "Unexpected Endings",
                    "city"
                ) to Pair(R.drawable.book12, "The Autumn Power"),
                Triple(
                    "Adventure",
                    "Emotional Depth",
                    "castle"
                ) to Pair(R.drawable.book13, "The Troop"),
                Triple(
                    "Horror",
                    "Emotional Depth",
                    "city"
                ) to Pair(R.drawable.book14, "The Girl Behind"),
                Triple(
                    "Poetry",
                    "Emotional Depth",
                    "city"
                ) to Pair(R.drawable.bookseven, "What We Set In Motion"),
                Triple(
                    "Detective Fiction",
                    "Emotional Depth",
                    "city"
                ) to Pair(R.drawable.booknine, "The Dawnlands Catch"),
            )

            runButton.setOnClickListener {
                val selectedGenre = genreSpinner.selectedItem.toString()
                val selectedBook = bookSpinner.selectedItem.toString()

                val result = bookMap[Triple(selectedGenre, selectedBook, userChoice)]

                val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val popupView = inflater.inflate(R.layout.activity_book_popup, null)
                val popupWindow = PopupWindow(popupView, 1000, 1700, true)
                popupWindow.showAtLocation(popupView, Gravity.BOTTOM, 0, 150)

                val bookImage: ImageView = popupView.findViewById(R.id.bookImage)
                val bookName: TextView = popupView.findViewById(R.id.bookName)
                val crossButton: ImageButton = popupView.findViewById(R.id.crossButton)

                if (result != null) {
                    bookImage.setImageResource(result.first)
                    bookName.text = result.second
                }
                crossButton.setOnClickListener {
                    popupWindow.dismiss()
                }
            }
        }
    }
}






