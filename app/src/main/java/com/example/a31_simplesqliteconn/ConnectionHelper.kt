package com.example.a31_simplesqliteconn

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ConnectionHelper(context: Context):SQLiteOpenHelper(context,"COMPANY",null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
     p0?.execSQL("CREATE TABLE LOGIN(USERNAME TEXT, PASSWORD TEXT)")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}