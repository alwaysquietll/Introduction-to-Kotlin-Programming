package com.example.okhttpdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textviewResponse = findViewById<TextView>(R.id.textview_response)
        val buttonGetRequest = findViewById<Button>(R.id.button_get)
        buttonGetRequest.setOnClickListener()
        {
            Thread()
            {
                val client = OkHttpClient()
                val request = Request.Builder().url("https://geekori.com/edu").build()
                val response = client.newCall(request).execute()
                val responseStr = response.body()?.string()
                runOnUiThread { textviewResponse.text = responseStr }
            }.start()
        }
        val buttonPostRequest = findViewById<Button>(R.id.button_post)
        buttonPostRequest.setOnClickListener()
        {
            Thread()
            {
                val requestBody = FormBody.Builder()
                    .add("name", "Bill")
                    .add("age", "30")
                    .build()
                val client = OkHttpClient()
                val request = Request.Builder().url("https://geekori.com/edu").post(requestBody).build()
                val response = client.newCall(request).execute()
                val responsStr = response.body()?.string()
                Log.d("OkHttpPost", responsStr)
            }.start()
        }
    }
}
