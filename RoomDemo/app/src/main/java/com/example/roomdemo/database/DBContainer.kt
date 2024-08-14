package com.example.roomdemo.database

import android.content.Context
import com.example.roomdemo.database.repository.ItemReopsitory
import com.example.roomdemo.database.repository.ItemRepositoryInterface

interface DBContainerInterface {
    val itemRepositoryInterface : ItemRepositoryInterface
}
class DBContainer(private val context : Context) : DBContainerInterface{
    override val itemRepositoryInterface: ItemRepositoryInterface by lazy{
        ItemReopsitory(RoomDB.getDatabase(context).ItemDao())
    }


}