package com.example.activitytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_layout)
        val data = intent.getStringExtra("extra_data")
        Log.d("ThirdActivity", "Extra data is: $data")
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
    }
}