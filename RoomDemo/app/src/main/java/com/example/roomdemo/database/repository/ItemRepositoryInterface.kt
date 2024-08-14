package com.example.roomdemo.database.repository

import com.example.roomdemo.database.entity.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepositoryInterface {

    suspend fun insert(item : Item)

    suspend fun delete(item : Item)

    suspend fun update(item : Item)

    fun getAllItems() : Flow<List<Item>>

    fun getItem(id : Int) :Flow<Item?>



}