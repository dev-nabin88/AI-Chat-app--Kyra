package com.example.kyra

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.runBlocking

class HomeActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



       

        val etprompt=findViewById<EditText>(R.id.etprompt)
        val sendbutton=findViewById<ImageButton>(R.id.sendbutton)
        val tvResult=findViewById<TextView>(R.id.tvResult)


        val generativeModel =
            GenerativeModel(
                // Specify a Gemini model appropriate for your use case
                modelName = "gemini-1.5-flash",
                // Access your API key as a Build Configuration variable (see "Set up your API key" above)
                apiKey = "AIzaSyAUn8yZSWt_lmI7GciOzFiubaZ1BPOGnEk")


        sendbutton.setOnClickListener {
            val prompt = etprompt.text.toString()


            runBlocking {
                val response = generativeModel.generateContent(prompt)
                print(response.text)

                tvResult.text = response.text

            }

        }


    }
}