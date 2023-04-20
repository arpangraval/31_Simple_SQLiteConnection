package com.example.a31_simplesqliteconn

import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var conhelper = ConnectionHelper(applicationContext)
        var db:SQLiteDatabase = conhelper.writableDatabase
        login_TV_S.setOnClickListener {

            startActivity(Intent(this,MainActivity::class.java))
        }
        signup_BTN_S.setOnClickListener {
            if(username_ET_S.text.toString()=="" || password_ET_S.text.toString()==""){
                Toast.makeText(this, "Enter All Credentials", Toast.LENGTH_LONG).show()
            }
            else
            {
             var rs:Cursor = db.rawQuery("SELECT * FROM LOGIN",null)
                var binsert = rs.count
                var cv = ContentValues()
             cv.put("USERNAME",username_ET_S.text.toString())
             cv.put("PASSWORD", password_ET_S.text.toString())
                db.insert("LOGIN",null,cv)
                rs.requery()
                var ainsert = rs.count
                if(ainsert > binsert){
                    Toast.makeText(this, "User Registered", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this,MainActivity::class.java))
                }
                else
                {
                    Toast.makeText(this, "User not Registered xxx", Toast.LENGTH_LONG).show()
                }


            }

        }

    }
}