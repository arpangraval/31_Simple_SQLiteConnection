package com.example.a31_simplesqliteconn

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        var conhelper = ConnectionHelper(applicationContext)
        var db: SQLiteDatabase = conhelper.writableDatabase

        var rs: Cursor = db.rawQuery("SELECT * FROM LOGIN",null)
        rs.moveToLast()
        textView.text = rs.getString(0)
        textView2.text = rs.getString(1)

    }
}