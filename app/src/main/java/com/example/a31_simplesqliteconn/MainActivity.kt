package com.example.a31_simplesqliteconn

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var conhelper = ConnectionHelper(applicationContext)
        var db:SQLiteDatabase = conhelper.writableDatabase

        login_BTN_L.setOnClickListener {
       if(userid_ET_L.text.toString() == "" || password_ET_L.text.toString()==""){
          Toast.makeText(this, "Enter All Credentials",Toast.LENGTH_LONG).show()
       }
            else
       {    var userid = userid_ET_L.text.toString()
            var pass = password_ET_L.text.toString()
           var args:Array<String> = arrayOf(userid,pass)
            var rs:Cursor = db.rawQuery("SELECT * FROM LOGIN WHERE USERNAME=? AND PASSWORD=?",args)
           var count = rs.count

           if(count>0){
                startActivity(Intent(this,Home::class.java))
            }
           else
            {
                Toast.makeText(this, "Invalid Credentials",Toast.LENGTH_LONG).show()
            }
       }




        }
        signup_TV_L.setOnClickListener {
          startActivity(Intent(this, SignUp::class.java))

        }


    }
}