package com.example.firstactivity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        var name:String? = intent.getStringExtra("name")
        var age:Int? = intent.getIntExtra("age", 0)
        if (name != null){
            Log.d("SecondActivity:name", name)
            Log.d("SecondActivity:age", java.lang.String.valueOf(age))
        }
    }
    fun onClick_Close(view: View){
        var intent = Intent()
        intent.putExtra("who", "Me")
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
