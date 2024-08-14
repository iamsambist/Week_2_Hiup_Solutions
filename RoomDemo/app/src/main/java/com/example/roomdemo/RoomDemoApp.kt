package com.example.roomdemo

import android.app.Application
import android.util.Log
import com.example.roomdemo.database.DBContainer

class RoomDemoApp : Application() {
    companion object{
        private var TAG = RoomDemoApp::class.java.simpleName
    }

    lateinit var dbContainer: DBContainer

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "oncreate")
        dbContainer = DBContainer(this)
    }
}