package com.example.roomdemo.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.roomdemo.RoomDemoApp
import com.example.roomdemo.database.entity.Item
import com.example.roomdemo.ui.theme.RoomDemoTheme
import com.example.roomdemo.view.ItemListView
import com.example.roomdemo.view.ItemView
import kotlinx.coroutines.launch

class ActivityHome : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoomDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val coroutineScope = rememberCoroutineScope()
                    val roomDemoapp = application as RoomDemoApp
                    val itemFlow  = roomDemoapp.dbContainer.itemRepositoryInterface.getAllItems()
                    var items by remember { mutableStateOf<List<Item>>(emptyList()) }
                    LaunchedEffect(itemFlow) {
                        itemFlow.collect{
                            itemlist -> items = itemlist
                        }
                    }
                    ItemListView(items = items)
                }
            }
        }
    }

//    private  suspend fun insertItem() {
//       val roomDemoapp = application as RoomDemoApp
//        var newItem = Item(name = "One Plus N200", quantity = 2, price = 25000.0)
//        roomDemoapp.dbContainer.itemRepositoryInterface.insert(newItem)
//    }
}