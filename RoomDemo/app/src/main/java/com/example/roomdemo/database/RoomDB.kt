package com.example.roomdemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdemo.database.dao.ItemDao
import com.example.roomdemo.database.entity.Item

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class RoomDB : RoomDatabase(){
    abstract fun ItemDao():ItemDao

    companion object{
        @Volatile
        var instance : RoomDB? =null

        fun getDatabase(context : Context) : RoomDB {
            return instance?: synchronized(this){
                Room.databaseBuilder(context,RoomDB::class.java,"room_database")
                    .build()
                    .also { instance = it }
            }
        }
    }
}