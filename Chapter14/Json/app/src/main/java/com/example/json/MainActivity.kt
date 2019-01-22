package com.example.json

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    val jsonFile = "/sdcard/test.json"
    val MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textviewJson = findViewById<TextView>(R.id.textviewJson)
        val buttonWriteJson = findViewById<Button>(R.id.buttonWriteJson)
        buttonWriteJson.setOnClickListener()
        {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE)
            }
            else
            {
                saveJson()
            }
        }
        val buttonReadJson = findViewById<Button>(R.id.buttonReadJson)
        buttonReadJson.setOnClickListener()
        {
            val fis = FileInputStream(jsonFile)
            val products = readJsonStream(fis)
            if (products != null)
            {
                var result = ""
                for (product in products)
                {
                    result += "id:" + product.id + " name:" + product.name + "\n";
                }
                textviewJson.setText(result)
            }
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    saveJson()
                } else {
                    Toast.makeText(this, "权限拒绝", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    fun saveJson()
    {
        val fos = FileOutputStream(jsonFile)
        val products = arrayListOf<Product>()
        products.add(Product("0001", "Nexus S"))
        products.add(Product("0002", "谷歌眼镜"))
        writeJsonStream(fos, products)
        Toast.makeText(this, "成功保存JSON数据", Toast.LENGTH_LONG).show()
    }
}
