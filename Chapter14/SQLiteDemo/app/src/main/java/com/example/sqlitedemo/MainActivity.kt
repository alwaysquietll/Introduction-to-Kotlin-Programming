package com.example.sqlitedemo

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val filename = filesDir.toString() + "/test.db"
        val textviewQueryResult = findViewById<TextView>(R.id.textview_query_result)
        val buttonCreateDatabaseTable = findViewById<Button>(R.id.button_create_database_table)
        buttonCreateDatabaseTable.setOnClickListener()
        {
            val createTableSQL = """CREATE TABLE [t_test] (
                |[id] INTEGER,
                |[name] VARCHAR(20),[memo] TEXT,
                |CONSTRAINT [sqlite_autoindex_t_test_1]
                |PRIMARY KEY ([id]))""".trimMargin()
            val file = File(filename)
            if (file.exists())
            {
                file.delete()
            }
            val database = SQLiteDatabase.openOrCreateDatabase(filename, null)
            database.execSQL(createTableSQL)
            database.close()
            Toast.makeText(this,"数据库与表已经成功建立！",Toast.LENGTH_LONG).show()
        }
        val buttonInsert = findViewById<Button>(R.id.button_insert)
        buttonInsert.setOnClickListener()
        {
            val database = SQLiteDatabase.openOrCreateDatabase(filename, null)
            val contentValues = ContentValues()
            contentValues.put("name", "Mike")
            contentValues.put("memo", "Student")
            database.insert("t_test", null, contentValues)

            val insertSQL = "insert into t_test(name, memo) values(?,?)"
            database.execSQL(insertSQL, arrayOf("John", "老师"))
            database.execSQL(insertSQL, arrayOf("Mary", "学生"))
            database.execSQL(insertSQL, arrayOf("王军", "校长"))
            database.close()
            Toast.makeText(this, "成功插入记录！", Toast.LENGTH_LONG).show()
        }

        val buttonDelete = findViewById<Button>(R.id.button_delete)
        buttonDelete.setOnClickListener()
        {
            val database = SQLiteDatabase.openOrCreateDatabase(filename, null)
            database.delete("t_test","name=?", arrayOf("John"))
            val deleteSQL = "delete from t_test where name=?"
            database.execSQL(deleteSQL, arrayOf("Mary"))
            database.close()
            Toast.makeText(this,"成功删除记录", Toast.LENGTH_LONG).show()
        }

        val buttonUpdate = findViewById<Button>(R.id.button_update)
        buttonUpdate.setOnClickListener()
        {
            val database = SQLiteDatabase.openOrCreateDatabase(filename, null)
            val contentValues = ContentValues()
            contentValues.put("name", "李宁")
            database.update("t_test", contentValues, "name=?", arrayOf("王军"))

            val updateSQL = "update t_test set name='Joe' where name=?"
            database.execSQL(updateSQL, arrayOf("Mike"))
            database.close()
            Toast.makeText(this,"成功更新记录", Toast.LENGTH_LONG).show()
        }

        val buttonQuery = findViewById<Button>(R.id.button_query)
        buttonQuery.setOnClickListener()
        {
            val database = SQLiteDatabase.openOrCreateDatabase(filename, null)
            var queryResult = ""
            val cursor1 = database.query("t_test", arrayOf("name","memo"), "name=?", arrayOf("Joe"),"","","")
            cursor1.moveToFirst()
            queryResult += cursor1.getString(0) + ":" + cursor1.getString(1) + "\r\n"
            val querySQL = "select name, memo from t_test where name=?"
            var cursor2 = database.rawQuery(querySQL, arrayOf("李宁"))
            cursor2.moveToFirst()
            queryResult += cursor2.getString(0) + ":" + cursor2.getString(1)
            textviewQueryResult.setText(queryResult)
            database.close()
        }
    }
}
