package com.example.httpurlconnectiondemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textviewResponse = findViewById<TextView>(R.id.textview_response)
        val buttonRequestResponse = findViewById<Button>(R.id.button_request_response)
        buttonRequestResponse.setOnClickListener()
        {
            Thread()
            {
                val url = URL("https://geekori.com")
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                connection.connectTimeout = 10000
                connection.readTimeout = 10000
                val inputStream = connection.inputStream
                val reader = inputStream.bufferedReader()
                var response = StringBuilder()
                while (true) {
                    val line = reader.readLine()
                    if (line == null)
                        break
                    response.append(line)
                }
                reader.close()
                connection.disconnect()
                runOnUiThread { textviewResponse.text = response}
            }.start()
        }
    }
}
