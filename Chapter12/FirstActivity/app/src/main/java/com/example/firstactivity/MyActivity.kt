package com.example.firstactivity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MyActivity : AppCompatActivity()
{
    private var edittext:EditText? = null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_activity)
        edittext = findViewById(R.id.edittext)
    }
    fun onClick(view:View)
    {
        edittext?.setText("hello world")
    }
    fun onClick_Toast(view:View){
        Toast.makeText(this, edittext?.text, Toast.LENGTH_LONG).show()
    }
    fun onClick_Close(view: View){
        finish()
    }
    fun onClick_ShowSecondActivity(view: View){
        //var intent = Intent(this, SecondActivity::class.java)
        var intent = Intent("com.example.firstactivity.SECOND_ACTIVITY")
        intent.addCategory("com.example.category.SECOND_ACTIVITY")
        intent.setData(Uri.parse("https://example.com"))
        startActivity(intent)
    }
    fun onClick_ShowWeb(view: View){
        var intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("https://example.com"))
        startActivity(intent)
    }
    fun onClick_ShowDial(view: View){
        var intent = Intent(Intent.ACTION_DIAL)
        intent.setData(Uri.parse("tel:12306"))
        startActivity(intent)
    }
    fun onClick_SendData(view: View){
        var intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("name", "Mary")
        intent.putExtra("age", 24)
        startActivity(intent)
    }
    fun onClick_ReturnData(view: View){
        var intent = Intent(this, SecondActivity::class.java)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode){
            1->{
                if(resultCode == Activity.RESULT_OK){
                    var returnData = data?.getStringExtra("who")
                    Log.d("MyActivity", returnData)
                }
            }
        }
    }
}