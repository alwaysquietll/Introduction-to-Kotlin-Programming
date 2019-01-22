package com.example.savelogin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        var usernameEditText = findViewById<EditText>(R.id.edittext_username)
        var passwordEditText = findViewById<EditText>(R.id.edittext_password)
        var saveCheckBox = findViewById<CheckBox>(R.id.checkbox_save)
        var loginButton = findViewById<Button>(R.id.button_login)
        loginButton.setOnClickListener()
        {
            var username = usernameEditText.text.toString()
            var password = passwordEditText.text.toString()
            if (username == "root" && password == "123456")
            {
                if (saveCheckBox.isChecked)
                {
                    var editor = sharedPreferences.edit()
                    editor.putString("username", username)
                    editor.putString("password", password)
                    editor.commit()
                    Toast.makeText(this,"登录成功，用户名和密码保存成功！",Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(this,"登录成功！",Toast.LENGTH_LONG).show()
                }
            }
            else
            {
                Toast.makeText(this, "用户名或密码输入错误！", Toast.LENGTH_LONG).show()
                usernameEditText.setText("")
                passwordEditText.setText("")
            }
        }
        var username = sharedPreferences.getString("username","")
        var password = sharedPreferences.getString("password","")
        usernameEditText.setText(username)
        passwordEditText.setText(password)
    }
}
