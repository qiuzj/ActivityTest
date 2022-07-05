package com.example.activitytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)

        val button: Button = findViewById(R.id.button1)
        button.setOnClickListener{
            Toast.makeText(this, "You click button1", Toast.LENGTH_SHORT).show()
        }
    }
}