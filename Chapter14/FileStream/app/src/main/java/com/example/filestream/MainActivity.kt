package com.example.filestream

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.io.File
import java.io.FileOutputStream
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    val MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textview_data)
        var buttonSave = findViewById<Button>(R.id.button_save)
        buttonSave.setOnClickListener()
        {
            val fileOutput = openFileOutput("data.txt", Activity.MODE_PRIVATE)
            val str = "微信小程序开发入门精要"
            fileOutput.write(str.toByteArray(Charset.forName("utf-8")))
            fileOutput.close()
            Toast.makeText(this,"成功保存数据",Toast.LENGTH_LONG).show()
        }
        var buttonLoad = findViewById<Button>(R.id.button_load)
        buttonLoad.setOnClickListener()
        {
            val fileInput = openFileInput("data.txt")
            fileInput.reader().forEachLine { textView.setText(it) }
            fileInput.close()
        }
        val buttonSaveImage = findViewById<Button>(R.id.button_save_image)
        buttonSaveImage.setOnClickListener()
        {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE)
            }
            else
            {
                saveImage()
            }
        }
        val buttonLoadImage = findViewById<Button>(R.id.button_load_image)
        buttonLoadImage.setOnClickListener()
        {
            val filename = "/sdcard/image.jpg"
            if (!File(filename).exists())
            {
                Toast.makeText(this, "图像文件不存在！",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val bitmap = BitmapFactory.decodeFile(filename)
            val imageView = findViewById<ImageView>(R.id.imageview)
            imageView.setImageBitmap(bitmap)
        }
    }
    fun saveImage()
    {
        val fos = FileOutputStream("/sdcard/image.jpg")
        val inputStream = resources.assets.open("image.jpg")
        val b = byteArrayOf(100)
        var count = 0
        while (true)
        {
            count = inputStream.read(b)
            if (count < 0)
            {
                break
            }
            fos.write(b,0,count)
        }
        fos.close()
        inputStream.close()
        Toast.makeText(this, "图像保存成功",Toast.LENGTH_LONG).show()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    saveImage()
                }
                else {

                }
            }
        }
    }
}
