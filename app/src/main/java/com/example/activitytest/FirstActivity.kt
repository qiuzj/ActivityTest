package com.example.activitytest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        val button4: Button = findViewById(R.id.button4)
        button4.setOnClickListener{
            // 只有<action>和<category>中的内容同时匹配Intent中指定的action和category时，这个Activity才能响应该Intent。
            // android.intent.category.DEFAULT是一种默认的category，在调用startActivity()方法的时候会自动将这个category添加到Intent中。
            val intent = Intent("com.example.activitytest.ACTION_START")
            intent.addCategory("com.example.activitytest.MY_CATEGORY")
            startActivity(intent)
        }

        val button5: Button = findViewById(R.id.button5)
        button5.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.baidu.com")
            // 拨号
//            val intent = Intent(Intent.ACTION_DIAL)
//            intent.data = Uri.parse("tel:666")
            startActivity(intent)
        }

        val button6: Button = findViewById(R.id.button6)
        button6.setOnClickListener{
            val intent = Intent(this, ThirdActivity::class.java)
            val data = "Hello ThirdActivity, I'm from FirstActiry"
            intent.putExtra("extra_data", data)
            startActivity(intent)
        }

        val button7: Button = findViewById(R.id.button7)
        button7.setOnClickListener{
            val intent = Intent(this, ThirdActivity::class.java)
            val data = "Hello ThirdActivity, I'm from FirstActiry"
            intent.putExtra("extra_data", data)
            startActivityForResult(intent, 1)
        }

        val button8: Button = findViewById(R.id.button8)
        button8.setOnClickListener{
            val intent = Intent(this, ThirdActivity::class.java)
            val data = "Hello ThirdActivity, I'm from FirstActiry"
            intent.putExtra("extra_data", data)
            startActivityForResult(intent, 2)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val returnedData = data?.getStringExtra("data_return")
                Log.d("FirstActivity", "[1] returned data is $returnedData")
            }
            2 -> if (resultCode == RESULT_OK) {
                val returnedData = data?.getStringExtra("data_return")
                Toast.makeText(this, "[2] return data is $returnedData", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // 创建菜单
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
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