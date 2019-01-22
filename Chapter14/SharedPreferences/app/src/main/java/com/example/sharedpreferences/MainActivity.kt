package com.example.sharedpreferences

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener()
        {
            var sharedPreferences = getSharedPreferences("test", Activity.MODE_PRIVATE)
            var editor = sharedPreferences.edit()
            editor.putString("url", "https://geekori.com")
            editor.putString("comment", "IT问答社区")
            editor.commit()
            Toast.makeText(this,"数据保存成功！", Toast.LENGTH_LONG).show()
        }
        var loadButton = findViewById<Button>(R.id.button_load)
        loadButton.setOnClickListener()
        {
            var sharedPreferences = getSharedPreferences("test", Activity.MODE_PRIVATE)
            val url = sharedPreferences.getString("url", "")
            val comment = sharedPreferences.getString("comment", "")
            Toast.makeText(this, "url: " + url + "\n" + "comment: " + comment, Toast.LENGTH_LONG).show()
        }
    }
}
