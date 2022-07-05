package com.example.activitytest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)

        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener{
            Toast.makeText(this, "You click button1", Toast.LENGTH_SHORT).show()
        }

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener{
            finish() // 销毁Activity
        }

        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    // 创建菜单
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true;
    }

    // 点击菜单行为
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "You click add", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "You click remove", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}