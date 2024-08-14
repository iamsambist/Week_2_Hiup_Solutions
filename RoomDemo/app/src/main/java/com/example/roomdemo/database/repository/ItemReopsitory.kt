package com.example.roomdemo.database.repository

import com.example.roomdemo.database.dao.ItemDao
import com.example.roomdemo.database.entity.Item
import kotlinx.coroutines.flow.Flow

class ItemReopsitory (private val itemDao : ItemDao) : ItemRepositoryInterface{
    override suspend fun insert(item: Item) {
        itemDao.insert(item)
    }

    override suspend fun delete(item: Item) {
       itemDao.delete(item)
    }

    override suspend fun update(item: Item) {
       itemDao.update(item)
    }

    override fun getAllItems(): Flow<List<Item>> {
      return itemDao.getAllItems()
    }

    override fun getItem(id: Int): Flow<Item?> {
        return itemDao.getItem(id)
    }

}