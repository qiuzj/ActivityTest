package com.example.activitytest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Process
import android.util.Log
import android.widget.Button
import android.widget.Toast

class ThirdActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_layout)
        val data = intent.getStringExtra("extra_data")
        Log.d("ThirdActivity", "Task id is $taskId. Extra data is: $data")
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show()

        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data_return", "Hello FirstActivity")
            setResult(RESULT_OK, intent)
            finish()
        }

        val button4: Button = findViewById(R.id.button4)
        button4.setOnClickListener {
            ActivityCollector.finishAll()
            // 杀掉当前进程的代码，以保证程序完全退出
            Process.killProcess(Process.myPid())
        }
    }

    companion object {
        fun actionStart(context: Context, extra_data: String) {
            val intent = Intent(context, ThirdActivity::class.java)
            intent.putExtra("extra_data", extra_data)
            context.startActivity(intent)
        }
    }
}