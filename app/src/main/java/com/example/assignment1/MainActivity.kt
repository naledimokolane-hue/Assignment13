package com.example.assignment1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var txtTime : EditText
    lateinit var btnSubmit : Button
    lateinit var btnReset : Button
    lateinit var txtResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        txtTime = findViewById(R.id.txtTime)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnReset = findViewById(R.id.btnReset)
        txtResult= findViewById(R.id.txtResult)


        btnSubmit.setOnClickListener {
            val time = txtTime.text.toString()
            var result = ""

            //Check all fields present
            if (time.isEmpty()) {
                txtResult.text = "Please enter the time of day"
            }

            if (time == "Morning"){
                result = "Send a 'Good morning' text to a family member"
            } else if (time == "Mid-day"){
                 result = "Respond to work e-mails and reach out to colleague with a 'Thank you'"
            } else if (time == "Afternoon"){
                result = "Share funny meme or video with a friend"
            } else if (time == "Evening"){
                result = "Leave a thoughtful comment on a friend's post"
            } else if (time == "Dinner"){
                result = "Relax or chat online with mutuals"
            } else if (time == "After dinner"|| time == "Night"){
                 result = "Call a friend or relative for a 5-minute catch-up"
            } else {
                 result = "Invalid input.Try:Morning,Afternoon,Dinner etc"
            }
            txtResult.text = result
        }
        btnReset.setOnClickListener {
            txtTime.text.clear()
            txtResult.text = ""
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}